/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.repository;

import com.realestate.domain.RealEstateAdRent;
import javax.transaction.Transactional;

/**
 *
 * @author Administrator
 */
@Transactional
public interface RealEstateAdRentRepository extends RealEstateAdRepositoryBase<RealEstateAdRent>{
    
}
