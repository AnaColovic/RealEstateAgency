/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.security;

import com.realestate.domain.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Administrator
 */
public class UserPrincipal implements UserDetails {

    private UserProfile userprofile;

    public UserPrincipal() {
    }

    public UserPrincipal(UserProfile userProfile) {
        this.userprofile = userProfile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String s : this.userprofile.getRoleList()) {
            GrantedAuthority authority = new SimpleGrantedAuthority(s);
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userprofile.getPassword();
    }

    @Override
    public String getUsername() {
        return userprofile.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userprofile.isActive();
    }

    public UserProfile getUserprofile() {
        return userprofile;
    }
    

}
