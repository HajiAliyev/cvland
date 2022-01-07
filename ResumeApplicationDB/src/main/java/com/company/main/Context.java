/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.impl.CountryDaoImpl;
import com.company.dao.impl.EmploymentHistoryDaoImpl;
import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;
import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;



/**
 *
 * @author ASUS
 */
public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl(); 
        //UserDaoImpl-i deyise bilerem. Qalan hisselerin xeberi olmaz ve isine normal davam edir. 
    }
    
    public static SkillDaoInter instanceSkillDao(){
        return new SkillDaoImpl();
    }
    
    public static CountryDaoInter instanceCountryDao(){
        return new CountryDaoImpl();
    }
    
    public static UserSkillDaoInter instanceUserSkillDao(){
        return new UserSkillDaoImpl();
    }

    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao(){
        return new EmploymentHistoryDaoImpl();
    }
}
