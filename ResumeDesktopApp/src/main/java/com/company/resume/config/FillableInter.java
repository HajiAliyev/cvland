/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.config;

import com.company.entity.User;

/**
 *
 * @author ASUS
 */
public interface FillableInter {
    
    public void fillUserComponents();
    public void fillUser(User user);

}
