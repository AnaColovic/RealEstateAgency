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

    @Autowired
    private VerificationTokenService verificationTokenService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public UserProfileDTO save(@RequestBody @Valid UserProfileDTO userProfileDTO) throws SQLIntegrityConstraintViolationException {
        UserProfile userProfile = mapDTOtoEntity(userProfileDTO);
        userProfile.setActive(false);
        UserProfile u = userProfileService.findByUsername(userProfile.getUsername());
        if(u!=null){
            throw new SQLIntegrityConstraintViolationException("Username is already taken!");
        }

        userProfileService.signUp(userProfile);

        VerificationToken verificationToken = new VerificationToken(userProfile);
        verificationTokenService.save(verificationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userProfile.getPerson().getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:4200/confirm-account?token=" + verificationToken.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);
        return mapEntityToDTO(userProfile);

    }

    @RequestMapping(value = "/confirm-account", method = RequestMethod.GET)
    public UserProfileDTO confirmUserProfile(@RequestParam("token") String confirmationToken) throws SQLIntegrityConstraintViolationException{
        UserProfile userProfile = null;
        VerificationToken token = verificationTokenService.findByConfirmationToken(confirmationToken);
        if (token != null) {
            userProfile = userProfileService.findByUsername(token.getUser().getUsername());
            userProfile.setActive(true);
            userProfileService.signUp(userProfile);
        }
        return mapEntityToDTO(userProfile);
    }

    public UserProfile mapDTOtoEntity(UserProfileDTO userProfileDTO) {
        Client client = modelMapper.map(userProfileDTO.getPerson(), Client.class);
        return new UserProfile(userProfileDTO.getUsername(), passwordEncoder.encode(userProfileDTO.getPassword()), userProfileDTO.getRoles(), true, client);
    }

    public UserProfileDTO mapEntityToDTO(UserProfile userProfile) {
        ClientDTO clientDTO = modelMapper.map(userProfile.getPerson(), ClientDTO.class);
        return new UserProfileDTO(userProfile.getId(), userProfile.getUsername(), userProfile.getPassword(), userProfile.getRoles(), clientDTO);
    }
}
