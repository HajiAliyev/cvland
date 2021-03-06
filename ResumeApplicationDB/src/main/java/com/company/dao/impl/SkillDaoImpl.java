/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getSkillList() {
        List<Skill> skillList = new ArrayList<>();
        try (Connection c = getConnectionToMysql()) {
            String sql = "select * from skill ";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                Skill skill = getSkill(rs);
                skillList.add(skill);
            }
            close(c, null, ps, rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return skillList;

    }

    private Skill getSkill(ResultSet rs) throws Exception {
        Integer skillId = rs.getInt("id");
        String name = rs.getString("name");
        Skill skill = new Skill(skillId, name);
        return skill;
    }

    @Override
    public Skill getSkillById(int id) {
        Skill result = null;
        try (Connection c = getConnectionToMysql()) {
            String sql = "select id, name from skill where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            boolean isPresent = ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                result = getSkill(rs);
            }
            close(c, null, ps, rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean addSkillAndReturnNewRowId(Skill skill) {//1-ci insert edir, sonra hemin yeni setrin id-sini verir. 
        boolean b = true;
        try (Connection c = getConnectionToMysql()) {
            String sql = "insert into skill (name) values(?);";
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, skill.getName());
            System.out.println("1...." + skill.getName());
            boolean isAdded = ps.execute();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                skill.setId(generatedKeys.getInt(1));
//                } else {
//                    throw new SQLException("Adding skill to user is failed. No UserSkill rowID obtained. -_-");
//                }
            }
            System.out.println("New Skill add: " + isAdded);
            c.setAutoCommit(true);
            close(c, null, ps, generatedKeys);
            return isAdded;
        } catch (Exception e) {
            b = false;
        }
        return b;

    }

    @Override
    public boolean updateSkill(Skill s) {
        try (Connection connection = getConnectionToMysql()) {
            String sql = "UPDATE SKILL SET NAME = ? WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, s.getId());
            boolean isUpdated = ps.execute();
            connection.setAutoCommit(true);
            System.out.println("Skill updated: " + isUpdated);
            return isUpdated;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeSkill(int id) {
        try (Connection c = getConnectionToMysql()) {
            String sql = "delete from skill where id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            boolean isRemoved = ps.execute();
            c.setAutoCommit(true);
            return isRemoved;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Skill getByName(String name) {
        Skill result = null;
        try (Connection c = getConnectionToMysql()) {
            String sql = "SELECT ID, NAME FROM SKILL WHERE NAME LIKE ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            boolean isPresent = ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                result = getSkill(rs);
            }
            close(c, null, ps, rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
