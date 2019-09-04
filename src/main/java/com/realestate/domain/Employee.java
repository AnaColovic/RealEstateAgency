/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.domain;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@DiscriminatorValue("employee")
public class Employee extends Person{
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    private String workbooknumber;

    public Employee() {
    }

    public Employee(Date hireDate, String workbooknumber,String firstName, String lastName, String email, String jmbg) {
        super( firstName, lastName, email, jmbg);
        this.hireDate = hireDate;
        this.workbooknumber = workbooknumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getWorkbooknumber() {
        return workbooknumber;
    }

    public void setWorkbooknumber(String workbooknumber) {
        this.workbooknumber = workbooknumber;
    }
    
    
}
