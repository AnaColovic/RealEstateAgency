/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.domain.RealEstateAdSell;
import com.realestate.dto.RealEstateAdSellDTO;
import com.realestate.service.RealEstateAdSellService;
import com.realestate.service.RealEstateAdService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/sell/*")
@CrossOrigin
public class RealEstateAdSellController {

    @Autowired
    private RealEstateAdSellService realEstateAdSellService;

    @Autowired
    private RealEstateAdService realEstateAdService;
    
    @Autowired
    private ServletContext context;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public void saveSellAd(@RequestBody @Valid RealEstateAdSellDTO realEstateAd) {
        realEstateAdSellService.saveOrUpdate(realEstateAd);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<RealEstateAdSellDTO> getAllSell() {
        List<RealEstateAdSellDTO> sellListDTO = realEstateAdSellService.getAll();
        
        for(RealEstateAdSellDTO sell : sellListDTO){
            String filePath = context.getRealPath("/realEstate");
            File fileFolder = new File(filePath);
            if (fileFolder != null) {
                for (final File file : fileFolder.listFiles()) {
                    if (!file.isDirectory() && file.getName().equals(sell.getRealEstate().getFileName())) {
                        String encodeBase64 = null;
                        try {
                            String extension = FilenameUtils.getExtension(file.getName());
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bytes = new byte[(int) file.length()];
                            fileInputStream.read(bytes);
                            encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                            sell.getRealEstate().setFileImg("data:image/" + extension + ";base64," + encodeBase64);
                            fileInputStream.close();

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(RealEstateController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(RealEstateController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        
        return sellListDTO;

    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public RealEstateAdSellDTO getSellAdById(@PathVariable int id) throws EntityNotFoundException{
        RealEstateAdSellDTO sellDTO = realEstateAdSellService.getById(id);
        
          String filePath = context.getRealPath("/realEstate");
            File fileFolder = new File(filePath);
            if (fileFolder != null) {
                for (final File file : fileFolder.listFiles()) {
                    if (!file.isDirectory() && file.getName().equals(sellDTO.getRealEstate().getFileName())) {
                        String encodeBase64 = null;
                        try {
                            String extension = FilenameUtils.getExtension(file.getName());
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bytes = new byte[(int) file.length()];
                            fileInputStream.read(bytes);
                            encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                            sellDTO.getRealEstate().setFileImg("data:image/" + extension + ";base64," + encodeBase64);
                            fileInputStream.close();

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(RealEstateController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(RealEstateController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        
        return sellDTO; 

    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteSellAd(@PathVariable int id) {
        realEstateAdService.delete(id);
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public List<RealEstateAdSellDTO> findSellAd(@RequestParam(value = "idcity", required = false, defaultValue = "0") int idcity,
            @RequestParam(value = "rooms", required = false, defaultValue = "0") double rooms, 
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "minPrice", required = false, defaultValue = "0") double minPrice,
            @RequestParam(value = "maxPrice", required = false, defaultValue = "0") double maxPrice,
            @RequestParam(value = "minArea", required = false, defaultValue = "0") double minArea,
            @RequestParam(value = "maxArea", required = false, defaultValue = "0") double maxArea) {
        List<RealEstateAdSellDTO> sellListDTO = realEstateAdSellService.findByCityRoomsType(idcity, rooms, type, minPrice, maxPrice, minArea, maxArea);
        
        
         for(RealEstateAdSellDTO sell : sellListDTO){
            String filePath = context.getRealPath("/realEstate");
            File fileFolder = new File(filePath);
            if (fileFolder != null) {
                for (final File file : fileFolder.listFiles()) {
                    if (!file.isDirectory() && file.getName().equals(sell.getRealEstate().getFileName())) {
                        String encodeBase64 = null;
                        try {
                            String extension = FilenameUtils.getExtension(file.getName());
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bytes = new byte[(int) file.length()];
                            fileInputStream.read(bytes);
                            encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                            sell.getRealEstate().setFileImg("data:image/" + extension + ";base64," + encodeBase64);
                            fileInputStream.close();

                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(RealEstateController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(RealEstateController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        
        return sellListDTO;

    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public void updateSellAd(@RequestBody @Valid RealEstateAdSellDTO realEstateAd, @PathVariable int id) {
        realEstateAdSellService.saveOrUpdate(realEstateAd);
    }

}
