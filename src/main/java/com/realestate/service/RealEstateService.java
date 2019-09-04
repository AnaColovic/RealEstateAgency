/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.RealEstate;
import java.util.List;


/**
 *
 * @author Administrator
 */
public interface RealEstateService {
    List<RealEstate> getAll();

    RealEstate findById(int id);

    RealEstate saveOrUpdate(RealEstate realestate);
    
    List<RealEstate> findByExample(RealEstate realEstate);
    
    void delete(int id);
}
