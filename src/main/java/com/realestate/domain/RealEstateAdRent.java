/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.domain;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Administrator
 */
@DiscriminatorValue("RENT")
@Entity
public class RealEstateAdRent extends RealEstateAd{
    private double rentprice;
    private int minimummonths;

    public RealEstateAdRent() {
    }
    
     public RealEstateAdRent(int id) {
         super(id);
    }
    
    public RealEstateAdRent(double rentprice, int minimummonths, int id, String description, Date creationDate, RealEstate realEstate) {
        super(id, description, creationDate, realEstate);
        this.rentprice = rentprice;
        this.minimummonths = minimummonths;
    }

    public double getRentprice() {
        return rentprice;
    }

    public void setRentprice(double rentprice) {
        this.rentprice = rentprice;
    }

    public int getMinimummonths() {
        return minimummonths;
    }

    public void setMinimummonths(int minimummonths) {
        this.minimummonths = minimummonths;
    }
    
    
}
