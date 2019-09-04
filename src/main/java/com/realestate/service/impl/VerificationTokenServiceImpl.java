/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service.impl;

import com.realestate.domain.VerificationToken;
import com.realestate.repository.VerificationTokenRepository;
import com.realestate.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class VerificationTokenServiceImpl implements VerificationTokenService{
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public VerificationToken findByConfirmationToken(String confirmationToken) {
        return verificationTokenRepository.findByConfirmationToken(confirmationToken);
    }

    @Override
    public VerificationToken save(VerificationToken verificationToken) {
        return verificationTokenRepository.save(verificationToken);
    }
    
}
