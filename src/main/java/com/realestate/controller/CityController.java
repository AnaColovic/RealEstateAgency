/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.domain.City;
import com.realestate.dto.CityDTO;
import com.realestate.service.CityService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 
 * */
@CrossOrigin
@RestController
@RequestMapping("/city/*")
public class CityController {
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private CityService cityService;
    
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<CityDTO> getAllCities() {
        List<City> cities = cityService.getAll();
        return cities.stream().map(city -> modelMapper.map(city, CityDTO.class)).collect(Collectors.toList());

    }
}
