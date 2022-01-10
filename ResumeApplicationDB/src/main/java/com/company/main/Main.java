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
import com.company.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author ASUS
 */
public class Main {

    private static UserDaoInter userDao = Context.instanceUserDao();
    private static SkillDaoInter skillDao = Context.instanceSkillDao();
    private static CountryDaoInter countryDao = Context.instanceCountryDao();
    private static UserSkillDaoInter userSkillDao = Context.instanceUserSkillDao();
    private static EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();

    public static void main(String[] args) throws Exception {
        System.out.println(userDao.getUserById(1));
    }
}
