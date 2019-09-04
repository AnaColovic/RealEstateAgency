/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
public class ViewingAppointmentDTO implements Serializable{
    private int id;
    @NotNull(message = "Date can not be null")
    private Date date;
    @NotNull(message = "Client can not be null!")
    private @Valid ClientDTO client;
    private RealEstateAdDTO realEstateAd;

    public ViewingAppointmentDTO() {
    }

    public ViewingAppointmentDTO(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public RealEstateAdDTO getRealEstateAd() {
        return realEstateAd;
    }

    public void setRealEstateAd(RealEstateAdDTO realEstateAd) {
        this.realEstateAd = realEstateAd;
    }

    @Override
    public String toString() {
        return "ViewingAppointmentDTO{" + "id=" + id + ", date=" + date + ", client=" + client + ", realEstateAd=" + realEstateAd + '}';
    }
    
    
    
    
    
}
