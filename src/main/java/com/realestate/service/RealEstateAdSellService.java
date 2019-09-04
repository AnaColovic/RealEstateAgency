/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.RealEstateAdSell;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface RealEstateAdSellService {

    void saveOrUpdate(RealEstateAdSell realestatead);

    List<RealEstateAdSell> getAll();

    RealEstateAdSell getById(int id);

    List<RealEstateAdSell> findByCityRoomsType(int idcity, double rooms, String type, double minPrice, double maxPrice, double minArea, double maxArea);

}
