package com.shubham.swapsie.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shubham.swapsie.exception.ResourceNotFoundException;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#createUser(User)}
     */
    @Test
    void testCreateUser() {
        User user = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles");

        when(userRepository.save((User) any())).thenReturn(user);
        when(passwordEncoder.encode((CharSequence) any())).thenReturn("secret");
        User user1 = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles");

        assertSame(user, userServiceImpl.createUser(user1));
        verify(userRepository).save((User) any());
        verify(passwordEncoder).encode((CharSequence) any());
        assertEquals("secret", user1.getPassword());
    }

    /**
     * Method under test: {@link UserServiceImpl#createUser(User)}
     */
    @Test
    void testCreateUser2() {
        when(userRepository.save((User) any()))
                .thenReturn(new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles"));
        when(passwordEncoder.encode((CharSequence) any())).thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl
                .createUser(new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles")));
        verify(passwordEncoder).encode((CharSequence) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getUsers()}
     */
    @Test
    void testGetUsers() {
        ArrayList<User> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);
        List<User> actualUsers = userServiceImpl.getUsers();
        assertSame(userList, actualUsers);
        assertTrue(actualUsers.isEmpty());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserServiceImpl#getUsers()}
     */
    @Test
    void testGetUsers2() {
        when(userRepository.findAll()).thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.getUsers());
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link UserServiceImpl#getUserById(long)}
     */
    @Test
    void testGetUserById() {
        User user = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles");

        when(userRepository.findById((Long) any())).thenReturn(Optional.of(user));
        assertSame(user, userServiceImpl.getUserById(1L));
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getUserById(long)}
     */
    @Test
    void testGetUserById2() {
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.getUserById(1L));
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#getUserById(long)}
     */
    @Test
    void testGetUserById3() {
        when(userRepository.findById((Long) any())).thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.getUserById(1L));
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(long, User)}
     */
    @Test
    void testUpdateUser() {
        User user = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles");

        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findById((Long) any()))
                .thenReturn(Optional.of(new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles")));
        when(passwordEncoder.encode((CharSequence) any())).thenReturn("secret");
        assertSame(user, userServiceImpl.updateUser(1L,
                new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles")));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(passwordEncoder).encode((CharSequence) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(long, User)}
     */
    @Test
    void testUpdateUser2() {
        when(userRepository.save((User) any()))
                .thenReturn(new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles"));
        when(userRepository.findById((Long) any()))
                .thenReturn(Optional.of(new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles")));
        when(passwordEncoder.encode((CharSequence) any())).thenThrow(new ResourceNotFoundException("An error occurred"));
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.updateUser(1L,
                new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles")));
        verify(userRepository).findById((Long) any());
        verify(passwordEncoder).encode((CharSequence) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(long, User)}
     */
    @Test
    void testUpdateUser3() {
        User user = mock(User.class);
        doThrow(new ResourceNotFoundException("An error occurred")).when(user).setEmail((String) any());
        doThrow(new ResourceNotFoundException("An error occurred")).when(user).setFName((String) any());
        doThrow(new ResourceNotFoundException("An error occurred")).when(user).setLName((String) any());
        doThrow(new ResourceNotFoundException("An error occurred")).when(user).setPassword((String) any());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.save((User) any()))
                .thenReturn(new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles"));
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        when(passwordEncoder.encode((CharSequence) any())).thenReturn("secret");
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.updateUser(1L,
                new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles")));
        verify(userRepository).findById((Long) any());
        verify(user).setFName((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#updateUser(long, User)}
     */
    @Test
    void testUpdateUser4() {
        when(userRepository.save((User) any()))
                .thenReturn(new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles"));
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        when(passwordEncoder.encode((CharSequence) any())).thenReturn("secret");
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.updateUser(1L,
                new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles")));
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#deleteUser(long)}
     */
    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any()))
                .thenReturn(Optional.of(new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles")));
        assertEquals("User F Name L Name with id : 1 deleted successfully", userServiceImpl.deleteUser(1L));
        verify(userRepository).findById((Long) any());
        verify(userRepository).delete((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#deleteUser(long)}
     */
    @Test
    void testDeleteUser2() {
        doThrow(new ResourceNotFoundException("An error occurred")).when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any()))
                .thenReturn(Optional.of(new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles")));
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.deleteUser(1L));
        verify(userRepository).findById((Long) any());
        verify(userRepository).delete((User) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#deleteUser(long)}
     */
    @Test
    void testDeleteUser3() {
        User user = mock(User.class);
        when(user.getFName()).thenThrow(new ResourceNotFoundException("An error occurred"));
        when(user.getLName()).thenThrow(new ResourceNotFoundException("An error occurred"));
        when(user.getId()).thenThrow(new ResourceNotFoundException("An error occurred"));
        Optional<User> ofResult = Optional.of(user);
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.deleteUser(1L));
        verify(userRepository).findById((Long) any());
        verify(userRepository).delete((User) any());
        verify(user).getFName();
    }

    /**
     * Method under test: {@link UserServiceImpl#deleteUser(long)}
     */
    @Test
    void testDeleteUser4() {
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        new ResourceNotFoundException("An error occurred");
        assertThrows(ResourceNotFoundException.class, () -> userServiceImpl.deleteUser(1L));
        verify(userRepository).findById((Long) any());
    }
}

