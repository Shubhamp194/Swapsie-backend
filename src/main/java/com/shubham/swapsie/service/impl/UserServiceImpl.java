package com.shubham.swapsie.service.impl;

import com.shubham.swapsie.exception.ResourceNotFoundException;
import com.shubham.swapsie.model.AuthRequest;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.repository.UserRepository;
import com.shubham.swapsie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id : "+id+" does not exist"));
    }

    @Override
    public User updateUser(long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("User with id : "+id+" does not exist"));
        user.setFName(updatedUser.getFName());
        user.setLName(updatedUser.getLName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public String deleteUser(long id) {
        User user = userRepository.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("User with id : "+id+" does not exist"));
        userRepository.delete(user);
        return "User "+user.getFName()+" "+user.getLName()+" with id : "+user.getId()+" deleted successfully";
    }

}
