/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class AbstractDAO {

    public Connection getConnectionToMysql() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver"); //This is deprecated. Artiq Driver-i demeye ehtiyac yoxdur.  
        String url = "jdbc:mysql://localhost:3306/resumedbap";
        String username = "root";
        String password = "12345";
//        try (
        Connection connection = DriverManager.getConnection(url, username, password);
//                        ) {
        Connection c = connection;
        System.out.println("getConnectionToMysql done successfully");
        return c;
//        } catch (SQLException ex) {
//            System.out.println("getConnectionToMysql is not working");
//            ex.printStackTrace();
//        } finally {
//            System.out.println("getConnectionToMysql is called");
//            return null;
    }

    public static void close(Connection c, Statement s, PreparedStatement ps, ResultSet rs) throws Exception {
        if (c != null) {
            c.close();
        }
        if (s != null) {
            s.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (rs != null) {
            rs.close();
        }

    }

}
