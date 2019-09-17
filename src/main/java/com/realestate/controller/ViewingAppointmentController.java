/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.domain.RealEstateAd;
import com.realestate.domain.ViewingAppointment;
import com.realestate.dto.RealEstateAdDTO;
import com.realestate.dto.ViewingAppointmentDTO;
import com.realestate.service.ViewingAppointmentService;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping("/appointment/*")
public class ViewingAppointmentController {

    @Autowired
    private ViewingAppointmentService viewingService;

    
     @RequestMapping(value = {"save/{id}"}, method = RequestMethod.POST)
    public ViewingAppointmentDTO saveViewingAppointment(@RequestBody @Valid ViewingAppointmentDTO viewingAppointmentDTO, @PathVariable int id) throws SQLIntegrityConstraintViolationException{
        viewingAppointmentDTO.setRealEstateAd(new RealEstateAdDTO(id));
        return viewingService.saveOrUpdate(viewingAppointmentDTO);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteViewingAppointment(@PathVariable int id) {
        viewingService.delete(id);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public void updateViewingAppointment(@RequestBody @Valid ViewingAppointmentDTO viewingAppointmentDTO, @PathVariable int id) throws SQLIntegrityConstraintViolationException{
        viewingService.saveOrUpdate(viewingAppointmentDTO);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<ViewingAppointmentDTO> getAllViewingAppointments() {
        return viewingService.getAll();
    }

    @RequestMapping(value = "get/{id}]", method = RequestMethod.GET)
    public ViewingAppointmentDTO getViewingAppointmentById(@PathVariable int id) throws EntityNotFoundException{
        return viewingService.findById(id);
    }
}
