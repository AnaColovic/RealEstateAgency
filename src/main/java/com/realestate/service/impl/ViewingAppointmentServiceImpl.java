/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.domain.RealEstateAd;
import com.realestate.domain.ViewingAppointment;
import com.realestate.dto.ViewingAppointmentDTO;
import com.realestate.repository.ViewingAppointmentRepository;
import com.realestate.service.ViewingAppointmentService;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class ViewingAppointmentServiceImpl implements ViewingAppointmentService {

    @Autowired
    private ViewingAppointmentRepository repository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ViewingAppointmentDTO> getAll() {
        List<ViewingAppointment> list = repository.findAll();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for(ViewingAppointment view: list){
            format.format(view.getDate());
        }
        return list.stream().map(appointment -> modelMapper.map(appointment, ViewingAppointmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ViewingAppointmentDTO findById(int id) {
        Optional<ViewingAppointment> viewingAppointment = repository.findById(id);
        if (viewingAppointment.isPresent()) {
            return modelMapper.map(viewingAppointment.get(), ViewingAppointmentDTO.class);
        }
        throw new EntityNotFoundException("Viewing Appointment with id = " + id + " does not exist!");
    }

    @Override
    public ViewingAppointmentDTO saveOrUpdate(ViewingAppointmentDTO viewingAppointment) {
        
        ViewingAppointment view = modelMapper.map(viewingAppointment, ViewingAppointment.class);
        view = repository.save(view);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.format(view.getDate());
        
        return modelMapper.map(view, ViewingAppointmentDTO.class);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}
