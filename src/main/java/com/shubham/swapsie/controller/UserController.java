package com.shubham.swapsie.controller;

import com.shubham.swapsie.model.LoginRequest;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        logger.info("New user Added");
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        logger.info("All Users List returned");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user = userService.getUserById(id);
        logger.info("User Searched");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        logger.info("User Removed");
        return userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User updatedUser){
        User user = userService.updateUser(id, updatedUser);
        logger.info("User Updated");
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest){
        User user = userService.login(loginRequest);
        logger.info("User Login successful");
        return user;
    }

}
