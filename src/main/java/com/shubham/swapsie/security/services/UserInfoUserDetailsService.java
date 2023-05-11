package com.shubham.swapsie.security.services;


import com.shubham.swapsie.model.User;
import com.shubham.swapsie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> userInfo = repo.findByEmail(username);
//            System.out.println("HELLO               ");
        return userInfo.map(UserToUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User Not Found!!" + username));
    }
}
