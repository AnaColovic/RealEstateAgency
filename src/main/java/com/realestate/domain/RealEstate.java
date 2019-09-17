/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Administrator
 */
@Entity
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrealestate;
    @Enumerated
    private TypeRealEstate type;
    private double rooms;
    private double area;
    private int floor;
    private String description;
    private String adress;
    @ManyToOne
    private City city;
    @ManyToOne
    private Client owner;
    
    private String fileName; 

    public RealEstate() {
    }

    public RealEstate(int idrealestate) {
        this.idrealestate = idrealestate;
    }

    public RealEstate(TypeRealEstate type, double rooms, double area, int floor, String description, String adress, City city, Client owner) {
        this.type = type;
        this.rooms = rooms;
        this.area = area;
        this.floor = floor;
        this.description = description;
        this.adress = adress;
        this.city = city;
        this.owner = owner;
    }
    
    public RealEstate(TypeRealEstate type, double rooms, double area, int floor, String description, String adress, City city, Client owner, String fileName) {
        this.type = type;
        this.rooms = rooms;
        this.area = area;
        this.floor = floor;
        this.description = description;
        this.adress = adress;
        this.city = city;
        this.owner = owner;
        this.fileName = fileName;
    }

    public int getIdrealestate() {
        return idrealestate;
    }

    public void setIdrealestate(int idrealestate) {
        this.idrealestate = idrealestate;
    }

    public TypeRealEstate getType() {
        return type;
    }

    public void setType(TypeRealEstate type) {
        this.type = type;
    }

    public double getRooms() {
        return rooms;
    }

    public void setRooms(double rooms) {
        this.rooms = rooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idrealestate;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RealEstate other = (RealEstate) obj;
        if (this.idrealestate != other.idrealestate) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RealEstate{" + "idrealestate=" + idrealestate + ", type=" + type + ", rooms=" + rooms + ", area=" + area + ", floor=" + floor + ", description=" + description + ", adress=" + adress + ", city=" + city + ", owner=" + owner + '}';
    }

}
