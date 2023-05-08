package com.shubham.swapsie.repository;

import com.shubham.swapsie.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    User user;


//    @BeforeEach
//    void setUp() {
//        User user = new User(100,"Test","User"
//                ,"Test@gmail.com","123");
//        userRepository.save(user);
//    }

//    @AfterEach
//    void tearDown() {
//        user = null;
//        userRepository.deleteAll();
//    }

    //SUCCESS
    @Test
    void testFindByEmailAndPassword_Found() {
        User user = new User(100,"Test","User"
                ,"Test@gmail.com","123");
        userRepository.save(user);
        User foundUser = userRepository.findByEmailAndPassword("Test@gmail.com","123");

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getId()).isEqualTo(user.getId());
        assertThat(foundUser.getFName()).isEqualTo(user.getFName());
    }

    //FAILURE
//    @Test
//    void findByEmailAndPassword_notFound() {
//        User foundUser = userRepository.findByEmailAndPassword("NotInDB","123");
//
//        assertThat(foundUser.getId()).isNotEqualTo(user.getId());
//        assertThat(foundUser.getFName()).isNotEqualTo(user.getLName());
//    }

}