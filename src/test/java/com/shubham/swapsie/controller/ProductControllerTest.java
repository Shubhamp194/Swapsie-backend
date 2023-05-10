package com.shubham.swapsie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shubham.swapsie.model.Product;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.service.ProductService;
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

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link ProductController#addProduct(Product)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddProduct() throws Exception {
        // TODO: Complete this test.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/product/add", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId(1L);
        product.setImgLink("Img Link");
        product.setName("Name");
        User user = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou");

        product.setUser(user);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(product));
        Object[] controllers = new Object[]{productController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link ProductController#deleteProduct(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteProduct() throws Exception {
        // TODO: Complete this test.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/product/delete/{id}",
                uriVariables);
        Object[] controllers = new Object[]{productController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link ProductController#getAllProducts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts() throws Exception {
        // TODO: Complete this test.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/getProducts", uriVariables);
        Object[] controllers = new Object[]{productController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link ProductController#getAllProductsBYUserId(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProductsBYUserId() throws Exception {
        // TODO: Complete this test.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/user/{user_id}",
                uriVariables);
        Object[] controllers = new Object[]{productController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link ProductController#getProductById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetProductById() throws Exception {
        // TODO: Complete this test.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/{id}", uriVariables);
        Object[] controllers = new Object[]{productController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result

    }

    /**
     * Method under test: {@link ProductController#updateProduct(long, Product)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateProduct() throws Exception {
        // TODO: Complete this test.

        // Arrange
        // TODO: Populate arranged inputs
        Object[] uriVariables = new Object[]{1L};
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/product/update/{id}", uriVariables)
                .contentType(MediaType.APPLICATION_JSON);

        Product product = new Product();
        product.setDescription("The characteristics of someone or something");
        product.setId(1L);
        product.setImgLink("Img Link");
        product.setName("Name");
        User user = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou");

        product.setUser(user);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(product));
        Object[] controllers = new Object[]{productController};
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(controllers).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        // TODO: Add assertions on result
    }
}

