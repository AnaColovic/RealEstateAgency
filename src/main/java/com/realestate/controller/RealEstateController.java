/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.google.gson.Gson;
import com.realestate.domain.RealEstate;
import com.realestate.dto.RealEstateDTO;
import com.realestate.service.RealEstateService;
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
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/realestate/*")
@CrossOrigin
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    @Autowired
    private ServletContext context;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public RealEstateDTO saveRealEstate(@RequestParam("realEstate") String realEstate, @RequestParam("realEstateImg") MultipartFile realEstateImg) throws MaxUploadSizeExceededException{
        Gson gson = new Gson();
        @Valid RealEstateDTO r = gson.fromJson(realEstate, RealEstateDTO.class);

        boolean isExist = new File(context.getRealPath("/realEstate/")).exists();
        if (!isExist) {
            new File(context.getRealPath("/realEstate/")).mkdir();
        }

        String fileName = realEstateImg.getOriginalFilename();
        String modifiedFileName = FilenameUtils.getBaseName(fileName) + "_" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(fileName);

        File file = new File(context.getRealPath("/realEstate/" + File.separator + modifiedFileName));
        try {
            FileUtils.writeByteArrayToFile(file, realEstateImg.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(RealEstateController.class.getName()).log(Level.SEVERE, null, ex);
        }

        r.setFileName(modifiedFileName);

        return realEstateService.saveOrUpdate(r);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<RealEstateDTO> getAllRealEstates() {
        List<RealEstateDTO> realEstates = realEstateService.getAll();

        for (RealEstateDTO r : realEstates) {
            String filePath = context.getRealPath("/realEstate");
            File fileFolder = new File(filePath);
            if (fileFolder != null) {
                for (final File file : fileFolder.listFiles()) {
                    if (!file.isDirectory() && file.getName().equals(r.getFileName())) {
                        String encodeBase64 = null;
                        try {
                            String extension = FilenameUtils.getExtension(file.getName());
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bytes = new byte[(int) file.length()];
                            fileInputStream.read(bytes);
                            encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                            r.setFileImg("data:image/" + extension + ";base64," + encodeBase64);
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

        return realEstates;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public RealEstateDTO getRealEstateById(@PathVariable int id) throws EntityNotFoundException{
        return realEstateService.findById(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public RealEstateDTO updateRealEstate(@RequestParam("realEstate") String realEstate, @RequestParam("realEstateImg") MultipartFile realEstateImg) throws MaxUploadSizeExceededException{
        Gson gson = new Gson();
        @Valid RealEstateDTO r = gson.fromJson(realEstate, RealEstateDTO.class);

        boolean isExist = new File(context.getRealPath("/realEstate/")).exists();
        if (!isExist) {
            new File(context.getRealPath("/realEstate/")).mkdir();
        }

        if (r.getFileName().equals("")) {
            String fileName = realEstateImg.getOriginalFilename();
            String modifiedFileName = FilenameUtils.getBaseName(fileName) + "_" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(fileName);

            File file = new File(context.getRealPath("/realEstate/" + File.separator + modifiedFileName));
            try {
                FileUtils.writeByteArrayToFile(file, realEstateImg.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(RealEstateController.class.getName()).log(Level.SEVERE, null, ex);
            }

            r.setFileName(modifiedFileName);
        }

        return realEstateService.saveOrUpdate(r);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteRealEstate(@PathVariable int id) {
        realEstateService.delete(id);
    }
}
