/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

/**
 *
 * @author ASUS
 */
public class Main {

    private static final UserDaoInter userDao = Context.instanceUserDao();
    private static final SkillDaoInter skillDao = Context.instanceSkillDao();
    private static final CountryDaoInter countryDao = Context.instanceCountryDao();
    private static final UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
    private static final EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();

    public static void main(String[] args) throws Exception {
        UserSkill u = new UserSkill(null, new User(1), new Skill(1, "asus"), 5);
        userSkillDao.addUserSkill(u);
        System.out.println(skillDao.getSkillList());
        
        UserSkill u1 = new UserSkill(1, new User(1), new Skill(1, "toshiba"), 6);
        userSkillDao.updateUserSkill(u1);
        System.out.println(skillDao.getSkillList());

    }
}
