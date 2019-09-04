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
public class RealEstateAdRentDTO extends RealEstateAdDTO {

    private double rentprice;
    private int minimummonths;

    public RealEstateAdRentDTO() {
        super();
    }

    public RealEstateAdRentDTO(double rentprice, int minimummonths, int id, String description, Date creationDate, RealEstateDTO realEstate, StatusRealEstateAd status) {
        super(id, description, creationDate, realEstate, status);
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
