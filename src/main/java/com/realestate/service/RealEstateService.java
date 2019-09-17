/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.RealEstate;
import com.realestate.dto.RealEstateDTO;
import java.util.List;


/**
 *
 * @author Administrator
 */
public interface RealEstateService {
    List<RealEstateDTO> getAll();

    RealEstateDTO findById(int id);

    RealEstateDTO saveOrUpdate(RealEstateDTO realestate);
        
    void delete(int id);
}
