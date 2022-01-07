/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author ASUS
 */
public class Queries {
    public static String SELECT_FROM_USER = "SELECT\n" +
"	u.*,\n" +
"	n.NAME AS nationality,\n" +
"	c.country_name AS birthplace \n" +
"FROM\n" +
"	USER u\n" +
"	LEFT JOIN nationality n ON u.nationality_id = n.id\n" +
"	LEFT JOIN nationality c ON u.birthplace_id = c.id\n" +
"	where u.active=1"; 
}
