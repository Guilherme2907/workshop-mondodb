/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.workshopmongo.service;

import com.guilherme.workshopmongo.service.util.Url;
import com.guilherme.workshopmongo.domain.Post;
import com.guilherme.workshopmongo.repository.PostRepository;
import com.guilherme.workshopmongo.service.exception.ObjectNotFoundException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado para o id: " + id));
    }

    public List<Post> findByTitle(String text) {
        text = Url.decodeParam(text);
        return postRepository.findByTitleContainingIgnoringCase(text);
    }

    public List<Post> fullSearch(String text, String minDate, String maxDate) {
        text = Url.decodeParam(text);
        Date min = Url.convertToDate(minDate, new Date(0L));
        Date max = Url.convertToDate(maxDate, new Date(System.currentTimeMillis() + 86400000));

        return postRepository.fullSearch(text, min, max);
    }
}
