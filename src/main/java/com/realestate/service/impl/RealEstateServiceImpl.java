/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.domain.RealEstate;
import com.realestate.domain.RealEstateAdRent;
import com.realestate.domain.RealEstateAdSell;
import com.realestate.repository.RealEstateAdRentRepository;
import com.realestate.repository.RealEstateAdSellRepository;
import com.realestate.repository.RealEstateRepository;
import com.realestate.service.RealEstateService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class RealEstateServiceImpl implements RealEstateService {

    @Autowired
    private RealEstateRepository realEstateRepository;
    
    @Autowired
    private RealEstateAdRentRepository realEstateAdRentR;
    
    @Autowired
    private RealEstateAdSellRepository realEstateAdSellR;

    @Override
    public List<RealEstate> getAll() {
        List<RealEstateAdRent> adRent = realEstateAdRentR.findAll();
        List<RealEstateAdSell> adSell = realEstateAdSellR.findAll();
        List<RealEstate> realEstates = realEstateRepository.findAll();
        
        for(RealEstateAdRent rent : adRent){
            if(realEstates.contains(rent.getRealEstate())){
                realEstates.remove(rent.getRealEstate());
            }
        }
        
        for(RealEstateAdSell sell : adSell){
            if(realEstates.contains(sell.getRealEstate())){
                realEstates.remove(sell.getRealEstate());
            }
        }
        
        return realEstates;      
    }

    @Override
    public RealEstate findById(int id) {
        Optional<RealEstate> realEstateOpt = realEstateRepository.findById(id);
        if (realEstateOpt.isPresent()) {
            return realEstateOpt.get();
        }
        throw new EntityNotFoundException("Real Estatate with id = " + id + " does not exist!");
    }

    @Override
    public RealEstate saveOrUpdate(RealEstate realestate) {
        return realEstateRepository.save(realestate);
    }

    @Override
    public List<RealEstate> findByExample(RealEstate realEstate) {
        ExampleMatcher matcher = ExampleMatcher.matching();
        return realEstateRepository.findAll(Example.of(realEstate,matcher));
    }

    @Override
    public void delete(int id) {
        realEstateRepository.deleteById(id);
    }

}
