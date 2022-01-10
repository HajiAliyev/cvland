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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getSkillList() {
        List<Skill> skillList = new ArrayList<>();
        try (Connection c = getConnectionToMysql()) {
            String sql = "select id, name from skill ";
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
        return result;
    }

    @Override
    public boolean addCountry(Skill c) {
        boolean isAdded = false;
        return isAdded;
    }

    @Override
    public boolean updateSkill(Skill c) {
        boolean isUpdated = false;
        return isUpdated;
    }

    @Override
    public boolean removeSkill(int id) {
        boolean isRemoved = false;
        return isRemoved;
    }
}
