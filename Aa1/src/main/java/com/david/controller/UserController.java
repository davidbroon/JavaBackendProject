package com.david.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.david.model.Post;
import com.david.model.Users;
import com.david.repository.UserRepository;

@RestController

public class UserController {
	
		@CrossOrigin
		@GetMapping("/values")
		public String[] getValues(){
		  return new String[] {"value1","value2"};
		}
	
    @Autowired
    UserRepository dao;
    
   
    
    @GetMapping("/user")
    public List<Users> getUsers(){
        List<Users> foundUsers = dao.findAll();
        return foundUsers;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable(value="id") Integer id){
        Users foundUser = dao.getOne(id);

        if(foundUser == null) {
            return ResponseEntity.notFound().header("User","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundUser);
    }

    @PostMapping("/user")
    public ResponseEntity<Users> postMessage(@RequestBody Users user){

      
        Users createdUser = dao.save(user);

        
        return ResponseEntity.ok(createdUser);
    }
    
    

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable(value="id") Integer id){
        Users foundUser = dao.getOne(id);

        if(foundUser == null) {
            return ResponseEntity.notFound().header("User","Nothing found with that id").build();
        }else {
            dao.delete(foundUser);
        }
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/user/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable (value="id") Integer id,
    		@RequestBody Post post) {
        return new ResponseEntity<>(new Users(), HttpStatus.OK);
}
}
