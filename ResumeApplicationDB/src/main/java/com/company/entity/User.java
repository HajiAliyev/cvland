/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.sql.Date;
import java.util.List;
import lombok.Data;

/**
 * @Data is a convenient shortcut annotation that bundles the features of
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor
 * together
 *
 */
@Data
public class User {

    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Date birthdate;
    private Country nationality;
    private Country birthPlace;
    private List<UserSkill> skills;

    public User() {
    }

    public User(int id, String name, String surname, String phone, String email, Date birthdate, Country nationality, Country birthPlace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email.toLowerCase();
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.birthPlace = birthPlace;
    }

    public User(int id) {
        this.id = id;
    }
}
