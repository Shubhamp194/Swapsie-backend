package com.shubham.swapsie.service.impl;

import com.shubham.swapsie.model.LoginRequest;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.repository.UserRepository;
import com.shubham.swapsie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User login(LoginRequest loginRequest) {

        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if(user == null)
            throw new RuntimeException("Did not find patient with these credentials");
        return user;
    }


}
