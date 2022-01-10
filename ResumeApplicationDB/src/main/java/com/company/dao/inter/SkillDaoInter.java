/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Skill;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface SkillDaoInter {

    public List<Skill> getSkillList();

    public Skill getSkillById(int id);
    
    public Skill getByName(String name);

    public boolean updateSkill(Skill s);

    public boolean addSkill(Skill s);

    public boolean removeSkill(int id);
}
