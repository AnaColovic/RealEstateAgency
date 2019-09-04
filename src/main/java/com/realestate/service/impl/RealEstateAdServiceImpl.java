/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.repository.RealEstateAdRepository;
import com.realestate.service.RealEstateAdService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class RealEstateAdServiceImpl implements RealEstateAdService{
    @Autowired
    private RealEstateAdRepository repository;

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    
}
