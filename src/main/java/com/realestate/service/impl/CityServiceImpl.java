/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.domain.City;
import com.realestate.dto.CityDTO;
import com.realestate.repository.CityRepository;
import com.realestate.service.CityService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository cityRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CityDTO> getAll() {
        List<City> cities =  cityRepository.findAllByOrderByName();
        return cities.stream().map(city -> modelMapper.map(city, CityDTO.class)).collect(Collectors.toList());
    }
    
}
