/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.workshopmongo.service;

import com.guilherme.workshopmongo.domain.User;
import com.guilherme.workshopmongo.repository.UserRepository;
import com.guilherme.workshopmongo.service.exception.ObjectNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado para o id: " + id));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User newUser,String id) {
        User user = findById(id);
        return userRepository.save(updateData(newUser, user));
    }

    private User updateData(User newUser, User user) {
        user.setNome(newUser.getNome());
        user.setEmail(newUser.getEmail());
        return user;
    }

}
