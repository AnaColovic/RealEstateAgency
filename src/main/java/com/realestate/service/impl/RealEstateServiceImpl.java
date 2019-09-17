/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.domain.RealEstate;
import com.realestate.domain.RealEstateAdRent;
import com.realestate.domain.RealEstateAdSell;
import com.realestate.dto.RealEstateDTO;
import com.realestate.repository.RealEstateAdRentRepository;
import com.realestate.repository.RealEstateAdSellRepository;
import com.realestate.repository.RealEstateRepository;
import com.realestate.service.RealEstateService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
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
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RealEstateDTO> getAll() {
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
        
        return realEstates.stream().map(realEstate -> modelMapper.map(realEstate, RealEstateDTO.class)).collect(Collectors.toList());      
    }

    @Override
    public RealEstateDTO findById(int id) {
        Optional<RealEstate> realEstateOpt = realEstateRepository.findById(id);
        if (realEstateOpt.isPresent()) {
            return modelMapper.map(realEstateOpt.get(), RealEstateDTO.class);
        }
        throw new EntityNotFoundException("Real Estatate with id = " + id + " does not exist!");
    }

    @Override
    public RealEstateDTO saveOrUpdate(RealEstateDTO realestate) {
        RealEstate r = modelMapper.map(realestate, RealEstate.class);
        r = realEstateRepository.save(r);
        return modelMapper.map(r, RealEstateDTO.class);
    }

    @Override
    public void delete(int id) {
        realEstateRepository.deleteById(id);
    }

}
