package com.david.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.model.Post;
import com.david.repository.PostRepository;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostRepository dao;

    @GetMapping("/post")
    public List<Post> getPosts(){
        List<Post> foundPosts = dao.findAll();
        return foundPosts;
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Post> getPost(@PathVariable(value="id") Integer id){
    	Post foundPost = dao.getOne(id);

        if(foundPost == null) {
            return ResponseEntity.notFound().header("Post","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundPost);
    }

    @PostMapping("/post")
    public ResponseEntity<Post> postMessage(@RequestBody Post post){

    
    	Post createdPost = dao.save(post);

        
        return ResponseEntity.ok(createdPost);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable(value="id") Integer id){
    	Post foundPost = dao.getOne(id);

        if(foundPost == null) {
            return ResponseEntity.notFound().header("Post","Nothing found with that id").build();
        }else {
            dao.delete(foundPost);
        }
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable (value="id") Integer id,
    		@RequestBody Post post) {
        return new ResponseEntity<>(new Post(), HttpStatus.OK);
}

    
}