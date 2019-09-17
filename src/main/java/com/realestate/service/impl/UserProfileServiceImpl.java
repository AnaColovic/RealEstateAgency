/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.domain.Client;
import com.realestate.domain.UserProfile;
import com.realestate.domain.VerificationToken;
import com.realestate.dto.ClientDTO;
import com.realestate.dto.UserProfileDTO;
import com.realestate.repository.UserProfileRepository;
import com.realestate.service.EmailSenderService;
import com.realestate.service.UserProfileService;
import com.realestate.service.VerificationTokenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class UserProfileServiceImpl implements UserProfileService{
    @Autowired
    private UserProfileRepository userProfileRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private VerificationTokenService verificationTokenService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    public UserProfileDTO signUp(UserProfileDTO userProfile) {
        UserProfile up = mapDTOtoEntity(userProfile);
        up = userProfileRepository.save(up);
        
        VerificationToken verificationToken = new VerificationToken(up);
        verificationTokenService.save(verificationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(up.getPerson().getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + "http://localhost:4200/confirm-account?token=" + verificationToken.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);
        
        return mapEntityToDTO(up);
    }
    
    @Override
    public UserProfileDTO confirmedAccount(String confirmationToken){
        UserProfile userProfile = null;
        VerificationToken token = verificationTokenService.findByConfirmationToken(confirmationToken);
        if (token != null) {
            userProfile = userProfileRepository.findByUsername(token.getUser().getUsername());
            userProfile.setActive(true);
            userProfileRepository.save(userProfile);
        }
        return mapEntityToDTO(userProfile);
    }

    @Override
    public UserProfileDTO findByUsername(String username){
        UserProfile userProfile = userProfileRepository.findByUsername(username);
        return mapEntityToDTO(userProfile);
    }
    
    private UserProfile mapDTOtoEntity(UserProfileDTO userProfileDTO) {
        if(userProfileDTO == null) return null;
        Client client = modelMapper.map(userProfileDTO.getPerson(), Client.class);
        return new UserProfile(userProfileDTO.getUsername(), passwordEncoder.encode(userProfileDTO.getPassword()), userProfileDTO.getRoles(), true, client);
    }

    private UserProfileDTO mapEntityToDTO(UserProfile userProfile) {
        if(userProfile == null) return null;
        ClientDTO clientDTO = modelMapper.map(userProfile.getPerson(), ClientDTO.class);
        return new UserProfileDTO(userProfile.getId(), userProfile.getUsername(), userProfile.getPassword(), userProfile.getRoles(), clientDTO);
    }
    
}
