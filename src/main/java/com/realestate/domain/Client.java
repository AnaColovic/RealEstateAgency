/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Administrator
 */
@Entity
@DiscriminatorValue("client")
public class Client extends Person {

    private String phoneNumber;

    public Client() {
    }
    
    public Client(int id){
        super(id);
    }

    public Client(String phoneNumber,String firstName, String lastName, String email, String jmbg) {
        super(firstName, lastName, email, jmbg);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
