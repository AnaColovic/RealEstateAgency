/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.domain.RealEstateAd;
import com.realestate.domain.ViewingAppointment;
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

    @Autowired
    private ModelMapper modelMapper;
    
     @RequestMapping(value = {"save/{id}"}, method = RequestMethod.POST)
    public ViewingAppointmentDTO save(@RequestBody @Valid ViewingAppointmentDTO viewingAppointmentDTO, @PathVariable int id) throws SQLIntegrityConstraintViolationException{
        ViewingAppointment viewingAppointment = modelMapper.map(viewingAppointmentDTO, ViewingAppointment.class);
        viewingAppointment.setRealEstateAd(new RealEstateAd(id));
        viewingAppointment = viewingService.saveOrUpdate(viewingAppointment);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.format(viewingAppointment.getDate());
               
        return modelMapper.map(viewingAppointment, ViewingAppointmentDTO.class);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        viewingService.delete(id);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody @Valid ViewingAppointmentDTO viewingAppointmentDTO, @PathVariable int id) throws SQLIntegrityConstraintViolationException{
        ViewingAppointment viewingAppointment = modelMapper.map(viewingAppointmentDTO, ViewingAppointment.class);
        viewingService.saveOrUpdate(viewingAppointment);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<ViewingAppointmentDTO> getAll() {
        List<ViewingAppointment> list = viewingService.getAll();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for(ViewingAppointment view: list){
            format.format(view.getDate());
        }
        return list.stream().map(appointment -> modelMapper.map(appointment, ViewingAppointmentDTO.class)).collect(Collectors.toList());
    }

    @RequestMapping(value = "get/{id}]", method = RequestMethod.GET)
    public ViewingAppointmentDTO getById(@PathVariable int id) throws EntityNotFoundException{
        ViewingAppointment viewingAppointment = viewingService.findById(id);
        return modelMapper.map(viewingAppointment, ViewingAppointmentDTO.class);
    }
}
