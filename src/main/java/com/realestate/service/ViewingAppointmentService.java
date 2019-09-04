/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.*;
import java.util.List;

/**
 *
 * @author Administrator
 */

public interface ViewingAppointmentService {
    List<ViewingAppointment> getAll();

    ViewingAppointment findById(int id);

    ViewingAppointment saveOrUpdate(ViewingAppointment viewingAppointment);
        
    void delete(int id);
}
