/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Administrator
 */
@Entity
@Table( uniqueConstraints = {@UniqueConstraint(columnNames = {"client_id","real_estate_ad_id"})})
public class ViewingAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RealEstateAd realEstateAd;
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

    public ViewingAppointment() {
    }

    public ViewingAppointment( Date date, RealEstateAd realEstateAd, Client client) {
        this.date = date;
        this.realEstateAd = realEstateAd;
        this.client = client;
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

    public RealEstateAd getRealEstateAd() {
        return realEstateAd;
    }

    public void setRealEstateAd(RealEstateAd realEstateAd) {
        this.realEstateAd = realEstateAd;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "ViewingAppointment{" + "id=" + id + ", date=" + date + ", realEstateAd=" + realEstateAd + ", client=" + client + '}';
    }
    
    

}
