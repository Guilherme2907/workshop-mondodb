/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.workshopmongo.config;

import com.guilherme.workshopmongo.domain.User;
import com.guilherme.workshopmongo.repository.UserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Guilherme
 */
@Configuration
public class Inicialization implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User julia = new User(null, "Julia Green", "julia@gmail.com");
        User carla = new User(null, "Carla Grey", "carla@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, julia, carla));
    }
}
