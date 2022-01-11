/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ASUS
 */
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return name;
    }

}
