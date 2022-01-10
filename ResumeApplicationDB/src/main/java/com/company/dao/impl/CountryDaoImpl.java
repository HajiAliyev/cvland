/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {

    @Override
    public List<Country> getCountryList() {
        List<Country> countryList = new ArrayList<>();
        try (Connection c = getConnectionToMysql()) {
            String sql = "select id, name, nationality from country";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                Country country = getCountry(rs);
                countryList.add(country);
            }
            close(c, null, ps, rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryList;
    }

    private Country getCountry(ResultSet rs) throws Exception {
        Integer countryId = rs.getInt("id");
        String name = rs.getString("name");
        String nationality = rs.getString("nationality");
        return new Country(countryId, name, nationality);
    }

    @Override
    public Country getCountryById(int id) {
        Country result = null;
        try (Connection c = getConnectionToMysql()) {
            String sql = "select id, name, nationality from country where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            boolean isPresent = ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                result = getCountry(rs);
            }
            close(c, null, ps, rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean addCountry(Country country) {
        try (Connection connection = getConnectionToMysql()) {
            String sql = "insert into country (name, nationality) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, country.getName());
            ps.setString(2, country.getNationality());

            boolean isAdded = ps.execute();
            System.out.println(isAdded);

            connection.setAutoCommit(true);
            close(connection, null, ps, null);

            return isAdded;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCountry(Country c) {
        try (Connection connection = getConnectionToMysql()) {

            String sql = "update country set name = ?, nationality = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getNationality());
            ps.setInt(3, c.getId());
            boolean isUpdated = ps.execute();
            connection.setAutoCommit(isUpdated);
            System.out.println("update Country worked successfully");
            return isUpdated;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCountry(int id) {
        try (Connection c = getConnectionToMysql()) {
            String sql = "delete from country where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            boolean isDeleted = ps.execute();
            c.setAutoCommit(true);
            return isDeleted;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
