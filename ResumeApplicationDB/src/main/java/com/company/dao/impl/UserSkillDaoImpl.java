/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.company.dao.inter.AbstractDAO;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws SQLException {
        int userSkillId = rs.getInt("userSkillId");
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        UserSkill userSkill = new UserSkill(userSkillId, new User(userId), new Skill(skillId, skillName), power);
        return userSkill;
    }

    @Override
    public List<UserSkill> getUserSkillsListByUserId(int userId) {
        List<UserSkill> userSkillsList = new ArrayList<>();
        try (Connection c = getConnectionToMysql()) {
            PreparedStatement ps = c.prepareStatement(" SELECT "
                    + " us.id as userSkillId, "
                    + "	u.*, "
                    + "	us.skill_id, "
                    + "	s.NAME AS skill_name, "
                    + "	us.power "
                    + " FROM "
                    + "	user_skill us "
                    + "	LEFT JOIN USER u ON us.user_id = u.id "
                    + "	LEFT JOIN skill s ON us.skill_id = s.id "
                    + " WHERE "
                    + "	us.user_id = ? "
                    + "	AND u.active = 1 ");
            ps.setInt(1, userId);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                UserSkill us = getUserSkill(rs);
                userSkillsList.add(us);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userSkillsList;
    }

    @Override
    public boolean addUserSkill(UserSkill u) {
        boolean isAdded = true;
        try (Connection c = getConnectionToMysql()) {
            String sql = "INSERT INTO user_skill (skill_id, user_id, power) values (?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, u.getSkill().getId());
            ps.setInt(2, u.getUser().getId());
            ps.setInt(3, u.getPower());
            isAdded = ps.execute();
            System.out.println("New Skill added to UserSkill: " + isAdded);
            c.setAutoCommit(true);
            close(c, null, ps, null);
            return isAdded;
        } catch (Exception e) {
            isAdded = false;
        }
        return isAdded;
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        boolean b = true;
        try (Connection connection = getConnectionToMysql()) {
            String sql = "UPDATE user_skill SET skill_id = ?, user_id = ?, power = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, u.getSkill().getId());
            ps.setInt(2, u.getUser().getId());
            ps.setInt(3, u.getPower());
            ps.setInt(4, u.getId());
            b = ps.execute();
            connection.setAutoCommit(true);
            System.out.println("User's Skill updated: " + b);
            close(connection, null, ps, null);
        } catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeUserSkill(int id) {
        try (Connection c = getConnectionToMysql()) {
            String sql = "delete from user_skill where id = ?";
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
}
