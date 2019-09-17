/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.RealEstateAdRent;
import com.realestate.dto.RealEstateAdRentDTO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface RealEstateAdRentService {

    void saveOrUpdate(RealEstateAdRentDTO realestatead);

    List<RealEstateAdRentDTO> getAll();

    RealEstateAdRentDTO getById(int id);

    List<RealEstateAdRentDTO> findByCityRoomsType(int idcity, double rooms, String type, double minPrice, double maxPrice, double minArea, double maxArea);
}
