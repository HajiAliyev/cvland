/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.User;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface UserDaoInter {

    public List<User> getUserList() throws Exception;

    public User getUserById(int id) throws Exception;

    public boolean addUser(User u) throws Exception;

    public boolean updateUser(User u) throws Exception;

    public boolean removeUser(int id) throws Exception;


}
