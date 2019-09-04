/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.service;

import com.realestate.domain.UserProfile;

/**
 *
 * @author Administrator
 */
public interface UserProfileService {
    
    UserProfile signUp(UserProfile userProfile);
    UserProfile findByUsername(String username);
    
}
