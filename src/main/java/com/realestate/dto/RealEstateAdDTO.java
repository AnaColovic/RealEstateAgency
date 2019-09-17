/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.dto;

import com.realestate.domain.StatusRealEstateAd;
import java.io.Serializable;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
public class RealEstateAdDTO implements Serializable {

    private int id;
    private String description;
    private Date creationDate;
    @NotNull(message = "Real Estate can not be null")
    private @Valid
    RealEstateDTO realEstate;
    private StatusRealEstateAd status;

    public RealEstateAdDTO() {
    }

    public RealEstateAdDTO(int id, String description, Date creationDate, RealEstateDTO realEstate, StatusRealEstateAd status) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.realEstate = realEstate;
        this.status = status;
    }

    public RealEstateAdDTO(int id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the realEstate
     */
    public RealEstateDTO getRealEstate() {
        return realEstate;
    }

    /**
     * @param realEstate the realEstate to set
     */
    public void setRealEstate(RealEstateDTO realEstate) {
        this.realEstate = realEstate;
    }

    /**
     * @return the status
     */
    public StatusRealEstateAd getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(StatusRealEstateAd status) {
        this.status = status;
    }

}
