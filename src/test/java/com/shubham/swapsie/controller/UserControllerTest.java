package com.shubham.swapsie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubham.swapsie.model.LoginRequest;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#createUser(User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateUser() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/user/register", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFName("F Name");
        user.setId(1L);
        user.setLName("L Name");
        user.setPassword("iloveyou");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(user));
        Object[] controllers = new Object[]{userController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link UserController#deleteUser(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteUser() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/user/delete/{id}", uriVariables);
        Object[] controllers = new Object[]{userController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link UserController#getUserById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserById() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/{id}", uriVariables);
        Object[] controllers = new Object[]{userController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link UserController#getUsers()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUsers() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/getUsers", uriVariables);
        Object[] controllers = new Object[]{userController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link UserController#login(LoginRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLogin() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/user/login", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("jane.doe@example.org");
        loginRequest.setPassword("iloveyou");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(loginRequest));
        Object[] controllers = new Object[]{userController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link UserController#updateUser(long, User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateUser() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/user/update/{id}", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFName("F Name");
        user.setId(1L);
        user.setLName("L Name");
        user.setPassword("iloveyou");

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(user));
        Object[] controllers = new Object[]{userController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }
}

