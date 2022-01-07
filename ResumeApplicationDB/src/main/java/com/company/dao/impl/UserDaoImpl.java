/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id"); // 2. String columnLabel qebul edir. int qaytarir.
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        Date birthdate = rs.getDate("birthDate");
        int nationalityId = rs.getInt("nationality_id");
        int birthPlaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthPlaceStr = rs.getString("birthplace");

        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthPlaceId, birthPlaceStr, null);

        return new User(id, name, surname, phone, email, birthdate, nationality, birthplace);
    }

    @Override
    public List<User> getUserList() {

//        int countRows = 0;
        List<User> userList = new ArrayList<>();
        try (//auto Closable olduguna gore try-with-resources
                Connection c = getConnectionToMysql();
                Statement statement = c.createStatement();) {
//            String oldQuery = "SELECT * FROM USER WHERE ACTIVE = 1";
            String query = "SELECT"
                    + "	u.*, "
                    + "	n.nationality AS nationality, "
                    + "	c.name AS birthplace "
                    + " FROM "
                    + "	USER u "
                    + "	LEFT JOIN country n ON u.nationality_id = n.id"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id"
                    + "	where u.active=1";
            boolean isExecuted = statement.execute(query);
            if (isExecuted) {
                ResultSet rs = statement.getResultSet();
                if (rs != null) {
                    while (rs.next()) {
                        User u = getUser(rs);
                        userList.add(u);
//                        System.out.println("ResultSet has next data rows: " + (++countRows));
                    }
                }
//                AbstractDAO.close(c, statement, rs); // try-with-resources buna ehtiyac duymur
            } else {
                System.out.println("query was not executed");
            }
            System.out.println(c.getClass().getName() + " . result has no next row data. getAllUsers() worked successfuly");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = getConnectionToMysql()) {
            PreparedStatement preparedStatement = c.prepareStatement("update user set name=?,surname=?,phone=?,email=? where id =? ");
            preparedStatement.setString(1, u.getName());
            preparedStatement.setString(2, u.getSurname());
            preparedStatement.setString(3, u.getPhone());
            preparedStatement.setString(4, u.getEmail());
            preparedStatement.setInt(5, u.getId());
            boolean isUpdated = preparedStatement.execute();
//            c.commit();
            c.setAutoCommit(true);
            System.out.println("updateUser worked successfully!");
            return isUpdated;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) throws Exception {
//Amma onceden yoxlamaq lazimdir ki, Bu id bazada varmi? Silende zaten User olmayan ID sece bilmez, ona gore de problem yasamariq.
        try (Connection c = getConnectionToMysql();
                Statement statement = c.createStatement();) {
            //statement.execute() Returns: true if the first result is a ResultSet object; false if the first result is an update count or there is no result.
            boolean isRemoved = statement.execute("update user set active = 0 where id = " + id);
//            boolean isRemoved = statement.execute("delete from user where id = " + id);
//            c.commit();
            c.setAutoCommit(true);
            return isRemoved;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(int userId) throws Exception {
        User result = null;
        try (Connection c = getConnectionToMysql()) {
//            String oldQuery = "select * from user where id = ?";

            String query = "SELECT"
                    + "	u.*, "
                    + "	n.nationality AS nationality, "
                    + "	c.name AS birthplace "
                    + " FROM "
                    + "	USER u "
                    + "	LEFT JOIN country n ON u.nationality_id = n.id"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id"
                    + "	where u.active=1 and where u.id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, userId);
            boolean isFound = ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                result = getUser(rs);
            }
            close(c, null, ps, rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u) throws Exception {
        try (Connection c = getConnectionToMysql()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO USER (NAME,SURNAME,PHONE,EMAIL) VALUES (?,?,?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getEmail());

            boolean isAdded = ps.execute();
            System.out.println(isAdded);
            c.setAutoCommit(true);
            close(null, null, ps, null);
            return isAdded;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    

}
