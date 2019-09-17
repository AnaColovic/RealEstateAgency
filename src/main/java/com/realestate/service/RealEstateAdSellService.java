/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.RealEstateAdSell;
import com.realestate.dto.RealEstateAdSellDTO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface RealEstateAdSellService {

    void saveOrUpdate(RealEstateAdSellDTO realestatead);

    List<RealEstateAdSellDTO> getAll();

    RealEstateAdSellDTO getById(int id);

    List<RealEstateAdSellDTO> findByCityRoomsType(int idcity, double rooms, String type, double minPrice, double maxPrice, double minArea, double maxArea);

}
