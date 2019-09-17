/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.controller;

import com.realestate.domain.Client;
import com.realestate.domain.UserProfile;
import com.realestate.domain.VerificationToken;
import com.realestate.dto.ClientDTO;
import com.realestate.dto.UserProfileDTO;
import com.realestate.service.EmailSenderService;
import com.realestate.service.UserProfileService;
import com.realestate.service.VerificationTokenService;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@CrossOrigin
@RestController
public class SignUpController {

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public UserProfileDTO signUp(@RequestBody @Valid UserProfileDTO userProfileDTO) throws SQLIntegrityConstraintViolationException {
        UserProfileDTO u = userProfileService.findByUsername(userProfileDTO.getUsername());
        if(u!=null){
            throw new SQLIntegrityConstraintViolationException("Username is already taken!");
        }
        userProfileDTO = userProfileService.signUp(userProfileDTO);
        return userProfileDTO;

    }

    @RequestMapping(value = "/confirm-account", method = RequestMethod.GET)
    public UserProfileDTO confirmUserProfile(@RequestParam("token") String confirmationToken) throws SQLIntegrityConstraintViolationException{
        return userProfileService.confirmedAccount(confirmationToken);
    }
}
