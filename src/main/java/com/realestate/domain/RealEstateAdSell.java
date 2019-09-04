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
@DiscriminatorValue("SELL")
@Entity
public class RealEstateAdSell extends RealEstateAd{
    private double price;
    private boolean registered;

    public RealEstateAdSell(double price, boolean registered, int id, String description, Date creationDate, RealEstate realEstate) {
        super(id, description, creationDate, realEstate);
        this.price = price;
        this.registered = registered;
    }

    public RealEstateAdSell() {
    }
    
     public RealEstateAdSell(int id) {
         super(id);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
    
    
    
}
