package com.shubham.swapsie.controller;

import com.shubham.swapsie.model.AuthRequest;
import com.shubham.swapsie.model.LoginResponse;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.repository.UserRepository;
import com.shubham.swapsie.security.services.JwtService;
import com.shubham.swapsie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        log.info("New user Added");
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        log.info("All Users List returned");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user = userService.getUserById(id);
        log.info("User Searched having id : "+id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        log.info("User Removed having id : "+id);
        return userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User updatedUser){
        User user = userService.updateUser(id, updatedUser);
        log.info("User Updated having id : "+id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            String token=jwtService.generateToken(authRequest.getEmail());
            User emp=this.userRepo.findByEmail(authRequest.getEmail()).orElseThrow();
            LoginResponse loginResponse=new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setRoles(emp.getRoles());
            loginResponse.setFname(emp.getFName());
            loginResponse.setEmail(emp.getEmail());
            loginResponse.setId(emp.getId());
            loginResponse.setLName(emp.getLName());
            return new ResponseEntity<>(loginResponse,HttpStatus.ACCEPTED);
        }
        else return new ResponseEntity<>("Invalid Username or password",HttpStatus.CONFLICT);
    }

}
