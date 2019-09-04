/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.dto;

import com.realestate.domain.TypeRealEstate;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
public class RealEstateDTO implements Serializable{
    private int idrealestate;
    private TypeRealEstate type;
    private double rooms;
    private double area;
    private int floor;
    private String description;
    @NotBlank(message = "Adress is required!")
    private String adress;
    @NotNull(message = "City can not be null!")
    private CityDTO city;
    @NotNull(message = "Owner can not be null!")
    private @Valid ClientDTO owner;
    
    private String fileName;
    private String fileImg;

    public RealEstateDTO() {
    }

    public RealEstateDTO(int idrealestate, TypeRealEstate type, double rooms, double area, int floor, String description, String adress, CityDTO city, ClientDTO owner) {
        this.idrealestate = idrealestate;
        this.type = type;
        this.rooms = rooms;
        this.area = area;
        this.floor = floor;
        this.description = description;
        this.adress = adress;
        this.city = city;
        this.owner = owner;
    }
    
    public RealEstateDTO(int idrealestate, TypeRealEstate type, double rooms, double area, int floor, String description, String adress, CityDTO city, ClientDTO owner, String fileName, String fileImg) {
        this.idrealestate = idrealestate;
        this.type = type;
        this.rooms = rooms;
        this.area = area;
        this.floor = floor;
        this.description = description;
        this.adress = adress;
        this.city = city;
        this.owner = owner;
        this.fileName = fileName;
        this.fileImg = fileImg;
    }

    /**
     * @return the idrealestate
     */
    public int getIdrealestate() {
        return idrealestate;
    }

    /**
     * @param idrealestate the idrealestate to set
     */
    public void setIdrealestate(int idrealestate) {
        this.idrealestate = idrealestate;
    }

    /**
     * @return the type
     */
    public TypeRealEstate getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeRealEstate type) {
        this.type = type;
    }

    /**
     * @return the rooms
     */
    public double getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(double rooms) {
        this.rooms = rooms;
    }

    /**
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(int floor) {
        this.floor = floor;
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
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the city
     */
    public CityDTO getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(CityDTO city) {
        this.city = city;
    }

    public ClientDTO getOwner() {
        return owner;
    }

    public void setOwner(ClientDTO owner) {
        this.owner = owner;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileImg() {
        return fileImg;
    }

    public void setFileImg(String fileImg) {
        this.fileImg = fileImg;
    }

    @Override
    public String toString() {
        return "RealEstateDTO{" + "idrealestate=" + idrealestate + ", type=" + type + ", rooms=" + rooms + ", area=" + area + ", floor=" + floor + ", description=" + description + ", adress=" + adress + ", city=" + city + ", owner=" + owner + ", fileName=" + fileName + ", fileImg=" + fileImg + '}';
    }

    

    
    
    
    
    
}
