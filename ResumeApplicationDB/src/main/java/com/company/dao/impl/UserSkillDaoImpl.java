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

/**
 *
 * @author ASUS
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int userId = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");

        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getUserSkillsListByUserId(int userId) throws Exception {
        List<UserSkill> userSkillsList = new ArrayList<>();
        try (Connection c = getConnectionToMysql()) {
            PreparedStatement ps = c.prepareStatement(" SELECT "
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
                UserSkill u = getUserSkill(rs);
                userSkillsList.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userSkillsList;
    }
}
