/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.domain.ViewingAppointment;
import com.realestate.repository.ViewingAppointmentRepository;
import com.realestate.service.ViewingAppointmentService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
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

    @Override
    public List<ViewingAppointment> getAll() {
        return repository.findAll();
    }

    @Override
    public ViewingAppointment findById(int id) {
        Optional<ViewingAppointment> viewingAppointment = repository.findById(id);
        if (viewingAppointment.isPresent()) {
            return viewingAppointment.get();
        }
        throw new EntityNotFoundException("Viewing Appointment with id = " + id + " does not exist!");
    }

    @Override
    public ViewingAppointment saveOrUpdate(ViewingAppointment viewingAppointment) {
        return repository.save(viewingAppointment);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}
