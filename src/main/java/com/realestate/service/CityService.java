/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.City;
import com.realestate.dto.CityDTO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface CityService {
    List<CityDTO> getAll();
}
