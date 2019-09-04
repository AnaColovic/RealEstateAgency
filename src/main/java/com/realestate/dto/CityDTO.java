/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.dto;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class CityDTO implements Serializable{
    private int idcity;
    private String name;

    public CityDTO() {
    }

    public CityDTO(int idcity, String name) {
        this.idcity = idcity;
        this.name = name;
    }

    public int getIdcity() {
        return idcity;
    }

    public void setIdcity(int idcity) {
        this.idcity = idcity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
