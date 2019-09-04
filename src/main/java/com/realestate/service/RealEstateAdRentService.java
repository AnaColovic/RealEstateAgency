/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.RealEstateAdRent;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface RealEstateAdRentService {

    void saveOrUpdate(RealEstateAdRent realestatead);

    List<RealEstateAdRent> getAll();

    RealEstateAdRent getById(int id);

    List<RealEstateAdRent> findByCityRoomsType(int idcity, double rooms, String type, double minPrice, double maxPrice, double minArea, double maxArea);
}
