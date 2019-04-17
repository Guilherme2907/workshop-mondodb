/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.workshopmongo.resources;

import com.guilherme.workshopmongo.domain.Post;
import com.guilherme.workshopmongo.domain.User;
import com.guilherme.workshopmongo.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Guilherme
 */
@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @GetMapping("/searchTitle")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(name = "title", defaultValue = "") String text) {
        return ResponseEntity.ok(postService.findByTitle(text));
    }

    @GetMapping("/fullSearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(name = "text", defaultValue = "") String text,
            @RequestParam(name = "minDate", defaultValue = "") String minDate,
            @RequestParam(name = "maxDate", defaultValue = "") String maxDate) {
        return ResponseEntity.ok(postService.fullSearch(text, minDate, maxDate));
    }
}
