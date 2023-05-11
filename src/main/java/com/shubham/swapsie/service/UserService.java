package com.shubham.swapsie.service;

import com.shubham.swapsie.model.AuthRequest;
import com.shubham.swapsie.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    List<User> getUsers();

    User getUserById(long id);

    User updateUser(long id, User updatedUser);

    String deleteUser(long id);

}
