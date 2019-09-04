/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author Administrator
 */
public interface EmailSenderService {
    public void sendEmail(SimpleMailMessage email);
}
