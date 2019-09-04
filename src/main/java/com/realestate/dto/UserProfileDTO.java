/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.dto;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
public class UserProfileDTO implements Serializable{
    private int id;
    @NotBlank(message = "Username is required!")
    private String username;
    @NotBlank(message = "Password is required!")
    private String password;
    private String roles;
    @NotNull(message = "Client can not be null!")
    private @Valid ClientDTO person;

    public UserProfileDTO() {
    }

    public UserProfileDTO(int id, String username, String password, String roles, ClientDTO person) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public ClientDTO getPerson() {
        return person;
    }

    public void setPerson(ClientDTO person) {
        this.person = person;
    }
    
    
}
