/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Administrator
 */
@Entity
public class City {

    @Id
    private int idcity;
    private String name;

    public City() {
    }

    public City(int cityid, String name) {
        this.idcity = cityid;
        this.name = name;
    }

    /**
     * @return the idcity
     */
    public int getIdcity() {
        return idcity;
    }

    /**
     * @param idcity the idcity to set
     */
    public void setIdcity(int idcity) {
        this.idcity = idcity;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" + "cityid=" + idcity + ", name=" + name + '}';
    }
    
    

}
