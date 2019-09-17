/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.domain.RealEstateAdSell;
import com.realestate.domain.TypeRealEstate;
import com.realestate.dto.RealEstateAdSellDTO;
import com.realestate.repository.RealEstateAdSellRepository;
import com.realestate.service.RealEstateAdSellService;
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
public class RealEstateAdSellServiceImpl implements RealEstateAdSellService {

    @Autowired
    private EntityManager em;
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RealEstateAdSellRepository repository;

    @Override
    public void saveOrUpdate(RealEstateAdSellDTO realestatead) {
        RealEstateAdSell r = modelMapper.map(realestatead, RealEstateAdSell.class);
        repository.save(r);
    }

    @Override
    public List<RealEstateAdSellDTO> getAll() {
        List<RealEstateAdSell> sellList =  repository.findAll();
        return sellList.stream().map(sell -> modelMapper.map(sell, RealEstateAdSellDTO.class)).collect(Collectors.toList());

    }

    @Override
    public RealEstateAdSellDTO getById(int id) {
        Optional<RealEstateAdSell> realEstateAd = repository.findById(id);
        if (realEstateAd.isPresent()) {
            return modelMapper.map(realEstateAd.get(), RealEstateAdSellDTO.class);
        }
        throw new EntityNotFoundException("Ad Sell with id = " + id + " does not exist");
    }

    @Override
    public List<RealEstateAdSellDTO> findByCityRoomsType(int idcity, double rooms, String type, double minPrice, double maxPrice, double minArea, double maxArea) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<RealEstateAdSell> rent = cq.from(RealEstateAdSell.class);

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
            predicate.add(cb.le(rent.get("price"), maxPrice));
            predicate.add(cb.ge(rent.get("price"), minPrice));
        } else if(minPrice != 0){
            predicate.add(cb.ge(rent.get("price"), minPrice));
        }
        
        if (maxArea != 0) {
            predicate.add(cb.le(rent.get("realEstate").get("area"), maxArea));
            predicate.add(cb.ge(rent.get("realEstate").get("area"), minArea));
        } else if(minArea != 0){
            predicate.add(cb.ge(rent.get("realEstate").get("area"), minArea));

        }

        cq.select(rent).where(predicate.toArray(new Predicate[]{}));
        List<RealEstateAdSell> sellList =  em.createQuery(cq).getResultList();
        return sellList.stream().map(sell -> modelMapper.map(sell, RealEstateAdSellDTO.class)).collect(Collectors.toList());

    }

}
