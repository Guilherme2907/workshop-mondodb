/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.workshopmongo.config;

import com.guilherme.workshopmongo.domain.Post;
import com.guilherme.workshopmongo.domain.User;
import com.guilherme.workshopmongo.repository.PostRepository;
import com.guilherme.workshopmongo.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
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
    
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User guilherme = new User(null, "Guilherme", "guilherme@gmail.com");
        User julia = new User(null, "Julia Green", "julia@gmail.com");
        User carla = new User(null, "Carla Grey", "carla@gmail.com");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        Post post1 = new Post(null, sdf.parse("21/01/2020"), "Partiu EUA", "Orlando...", guilherme);
        Post post2 = new Post(null, sdf.parse("21/01/2018"), "Partiu Viagem","Sao Paulo", julia);
        
        postRepository.saveAll(Arrays.asList(post1, post2));
        userRepository.saveAll(Arrays.asList(guilherme, julia, carla));
    }
}
