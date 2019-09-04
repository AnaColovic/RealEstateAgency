/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.dto;

import com.realestate.domain.StatusRealEstateAd;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class RealEstateAdSellDTO extends RealEstateAdDTO{

    private double price;
    private boolean registered;

    public RealEstateAdSellDTO() {
        super();
    }

    public RealEstateAdSellDTO(double price, boolean registered, int id, String description, Date creationDate, RealEstateDTO realEstate, StatusRealEstateAd status) {
        super(id, description, creationDate, realEstate, status);
        this.price = price;
        this.registered = registered;
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
