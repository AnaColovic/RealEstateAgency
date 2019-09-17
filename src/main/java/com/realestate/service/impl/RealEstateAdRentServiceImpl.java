/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.domain.RealEstateAdRent;
import com.realestate.domain.TypeRealEstate;
import com.realestate.dto.RealEstateAdRentDTO;
import com.realestate.repository.RealEstateAdRentRepository;
import com.realestate.service.RealEstateAdRentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
@Transactional
public class RealEstateAdRentServiceImpl implements RealEstateAdRentService {

    @Autowired
    private RealEstateAdRentRepository repository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EntityManager em;

    @Override
    public void saveOrUpdate(RealEstateAdRentDTO realestatead) {
        RealEstateAdRent rent = modelMapper.map(realestatead, RealEstateAdRent.class);
        repository.save(rent);
    }

    @Override
    public List<RealEstateAdRentDTO> getAll() {
        List<RealEstateAdRent> rentList = repository.findAll();
        return rentList.stream().map(rent -> modelMapper.map(rent, RealEstateAdRentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public RealEstateAdRentDTO getById(int id) {
        Optional<RealEstateAdRent> realEstateAd = repository.findById(id);
        if (realEstateAd.isPresent()) {
            return modelMapper.map(realEstateAd.get(), RealEstateAdRentDTO.class);
        }
        throw new EntityNotFoundException("Rent Ad with id = " + id + " does not exist!");
    }

    @Override
    public List<RealEstateAdRentDTO> findByCityRoomsType(int idcity, double rooms, String type, double minPrice, double maxPrice, double minArea, double maxArea) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<RealEstateAdRent> rent = cq.from(RealEstateAdRent.class);

        List<Predicate> predicate = new ArrayList<>();

        if (idcity != 0) {
            predicate.add(cb.equal(rent.get("realEstate").get("city").get("idcity"), idcity));
        }
        if (rooms != 0) {
            predicate.add(cb.equal(rent.get("realEstate").get("rooms"), rooms));
        }
        if (!type.equals("-1")) {
            predicate.add(cb.equal(rent.get("realEstate").get("type"), TypeRealEstate.valueOf(type)));
        }

        if (maxPrice != 0) {
            predicate.add(cb.le(rent.get("rentprice"), maxPrice));
            predicate.add(cb.ge(rent.get("rentprice"), minPrice));
        }  else if(minPrice != 0){
            predicate.add(cb.ge(rent.get("rentprice"), minPrice));            
        }
        
        if (maxArea != 0) {
            predicate.add(cb.le(rent.get("realEstate").get("area"), maxArea));
            predicate.add(cb.ge(rent.get("realEstate").get("area"), minArea));
        }else if(minArea != 0){
            predicate.add(cb.ge(rent.get("realEstate").get("area"), minArea));            
        }

        cq.select(rent).where(predicate.toArray(new Predicate[]{}));
        List<RealEstateAdRent> rentList =  em.createQuery(cq).getResultList();
        return rentList.stream().map(r -> modelMapper.map(r, RealEstateAdRentDTO.class)).collect(Collectors.toList());
    }
}
