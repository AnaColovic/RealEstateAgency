/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Administrator
 */
public class ClientDTO implements Serializable{

    private int id;
    @NotBlank(message = "First name is required!")
    @Pattern(regexp = "[a-zA-Z ]*", message = "First name must only contains letters!")
    private String firstname;
    @NotBlank(message = "Last name is required!")
    @Pattern(regexp = "[a-zA-Z ]*", message = "Last name must only contains letters!")
    private String lastname;
    @NotBlank(message = "Email is required!")
    @Email(message = "This must be a valid email adress!")
    private String email;
    @NotBlank(message = "JMBG is required!")
    @Length(min = 13, max = 13, message = "JMBG must be 13 characters long!")
    @Pattern(regexp = "[0-9]*", message = "JMBG must only contains numbers!")
    private String jmbg;
    @NotBlank(message = "Phone number is required!")
    @Pattern(regexp = "[0-9 ]*", message = "Phone number must only contains numbers!")
    private String phoneNumber;

    public ClientDTO() {
    }

    public ClientDTO(int id, String firstname, String lastname, String email, String jmbg, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.jmbg = jmbg;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
