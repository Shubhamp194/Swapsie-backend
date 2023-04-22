package com.shubham.swapsie.controller;

import com.shubham.swapsie.model.LoginRequest;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User updatedUser){
        User user = userService.updateUser(id, updatedUser);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest){
        User user = userService.login(loginRequest);
        return user;
    }

}
