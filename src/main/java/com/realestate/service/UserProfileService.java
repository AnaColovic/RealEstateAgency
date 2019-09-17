/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.UserProfile;
import com.realestate.dto.UserProfileDTO;

/**
 *
 * @author Administrator
 */
public interface UserProfileService {
    
    UserProfileDTO signUp(UserProfileDTO userProfile);
    UserProfileDTO findByUsername(String username);
    UserProfileDTO confirmedAccount(String confirmationToken);
    
}
