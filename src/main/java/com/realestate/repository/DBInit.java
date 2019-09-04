/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.realestate.repository;

import com.realestate.domain.Client;
import com.realestate.domain.Employee;
import com.realestate.domain.UserProfile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {

    private UserProfileRepository userProfileRepository;
    private PasswordEncoder passwordEncoder;

    public DBInit(UserProfileRepository userProfileRepository, PasswordEncoder passwordEncoder) {
        this.userProfileRepository = userProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
       // userProfileRepository.deleteAll();

        UserProfile admin1 = new UserProfile("ana", passwordEncoder.encode("ana123"), "ADMIN", true, new Employee(new Date(),
                "1123", "Ana", "Colovic", "ana@gmail.com", "23654789"));
        UserProfile admin2 = new UserProfile("jovana", passwordEncoder.encode("jovana123"), "ADMIN", true, new Employee(new Date(),
                "1456", "Jovana", "Mitrovic", "jovana@gmail.com", "12587777"));
        UserProfile user = new UserProfile("ludidzudi", passwordEncoder.encode("ludidzudi"), "USER", true, new Client("065555555", "Ana", "Dzudovic", "ludidzudi@gmail.com", "12547965"));

        List<UserProfile> users = Arrays.asList(admin1, admin2, user);

        // Save to db
        //userProfileRepository.saveAll(users);
    }
}
