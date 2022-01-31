package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class User_Controller {

    @Autowired
    private User_Service userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get_User_By_Id(@PathVariable("id") int id){
        return ResponseEntity.ok(userService.get_User_By_Id(id));
    }

    @PostMapping
    public ResponseEntity<User> create_User(@RequestBody User user){
        return ResponseEntity.ok(userService.create_User(user));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> delete_User(User user){
        return ResponseEntity.ok(userService.delete_User(user));
    }

    @PutMapping("/put")
        public ResponseEntity<User> put_User(User user){
            return ResponseEntity.ok(userService.put_User(user));
        }


}
