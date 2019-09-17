/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.*;
import com.realestate.dto.ViewingAppointmentDTO;
import java.util.List;

/**
 *
 * @author Administrator
 */

public interface ViewingAppointmentService {
    List<ViewingAppointmentDTO> getAll();

    ViewingAppointmentDTO findById(int id);

    ViewingAppointmentDTO saveOrUpdate(ViewingAppointmentDTO viewingAppointment);
        
    void delete(int id);
}
