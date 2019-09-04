/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.domain;

import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
@Entity
public class RealEstateAd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String description;
    @Temporal(TemporalType.DATE)
    protected Date creationDate;
    @ManyToOne
    protected RealEstate realEstate;
    @Enumerated
    protected StatusRealEstateAd status;
    
    @PrePersist
    protected void prePersist() {
        if (creationDate == null) {
            creationDate = new Date();
        }
        status = StatusRealEstateAd.NOT_APPROVED;
    }

    public RealEstateAd() {
    }
    
    public RealEstateAd(int id) {
        this.id = id;
    }

    public RealEstateAd(int id, String description, Date creationDate, RealEstate realEstate) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.realEstate = realEstate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public RealEstate getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(RealEstate realEstate) {
        this.realEstate = realEstate;
    }

    public StatusRealEstateAd getStatus() {
        return status;
    }

    public void setStatus(StatusRealEstateAd status) {
        this.status = status;
    }

}
