/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.repository;

import com.realestate.domain.RealEstateAd;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author Administrator
 * @param <T>
 */
@NoRepositoryBean
public interface RealEstateAdRepositoryBase<T extends RealEstateAd>  extends JpaRepository<T, Integer>{
    List<RealEstateAd> findByRealEstateAdress(String adress);
}
