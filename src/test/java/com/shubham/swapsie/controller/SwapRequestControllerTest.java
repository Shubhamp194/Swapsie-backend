package com.shubham.swapsie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubham.swapsie.model.Product;
import com.shubham.swapsie.model.SwapRequest;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.service.SwapRequestService;
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

@ContextConfiguration(classes = {SwapRequestController.class})
@ExtendWith(SpringExtension.class)
class SwapRequestControllerTest {
    @Autowired
    private SwapRequestController swapRequestController;

    @MockBean
    private SwapRequestService swapRequestService;

    /**
     * Method under test: {@link SwapRequestController#acceptSwapRequest(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAcceptSwapRequest() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/swapRequest/{id}/accept", uriVariables);
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#createSwapRequest(SwapRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateSwapRequest() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/swapRequest/create", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        SwapRequest swapRequest = new SwapRequest();
        swapRequest.setId(1L);
        Product product1 = new Product();
        swapRequest.setProduct1(product1);
        Product product2 = new Product();
        swapRequest.setProduct2(product2);
        swapRequest.setStatus("Status");
        User user1 = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou");

        swapRequest.setUser1(user1);
        User user2 = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou");

        swapRequest.setUser2(user2);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(swapRequest));
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#declineSwapRequest(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeclineSwapRequest() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/swapRequest/{id}/decline",
                uriVariables);
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#deleteSwapRequest(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteSwapRequest() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/swapRequest/delete/{id}",
                uriVariables);
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#getAllSwapRequests()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllSwapRequests() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/swapRequest/getAllSwapRequests",
                uriVariables);
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#getAllSwapRequestsByProduct1(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllSwapRequestsByProduct1() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/swapRequest/getAllSwapRequestsByProduct1/{product1_id}", uriVariables);
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#getAllSwapRequestsByProduct2(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllSwapRequestsByProduct2() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/swapRequest/getAllSwapRequestsByProduct2/{product2_id}", uriVariables);
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#getAllSwapRequestsByUser1(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllSwapRequestsByUser1() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/swapRequest/getAllSwapRequestsByUser1/{user1_id}", uriVariables);
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#getAllSwapRequestsByUser2(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllSwapRequestsByUser2() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/swapRequest/getAllSwapRequestsByUser2/{user2_id}", uriVariables);
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#getSwapRequestById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSwapRequestById() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/swapRequest/get/{id}", uriVariables);
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link SwapRequestController#updateSwapRequest(long, SwapRequest)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateSwapRequest() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .put("/swapRequest/update/{id}", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        SwapRequest swapRequest = new SwapRequest();
        swapRequest.setId(1L);
        Product product1 = new Product();
        swapRequest.setProduct1(product1);
        Product product2 = new Product();
        swapRequest.setProduct2(product2);
        swapRequest.setStatus("Status");
        User user1 = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou");

        swapRequest.setUser1(user1);
        User user2 = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou");

        swapRequest.setUser2(user2);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(swapRequest));
        Object[] controllers = new Object[]{swapRequestController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }
}

