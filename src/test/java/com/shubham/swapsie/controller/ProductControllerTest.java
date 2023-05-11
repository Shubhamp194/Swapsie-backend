package com.shubham.swapsie.controller;

import static org.mockito.Mockito.mock;

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
    void testAddProduct() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        ProductController productController = new ProductController();
        productController.addProduct(new Product());
    }

    /**
     * Method under test: {@link ProductController#addProduct(Product)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddProduct2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new ProductController()).addProduct(mock(Product.class));
    }

    /**
     * Method under test: {@link ProductController#addProduct(Product)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddProduct3() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

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
        User user = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles");

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
    void testDeleteProduct2() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

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
    void testGetAllProducts() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new ProductController()).getAllProducts();
    }

    /**
     * Method under test: {@link ProductController#getAllProducts()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProducts2() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

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
    void testGetAllProductsBYUserId2() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

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
    void testGetProductById() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new ProductController()).getProductById(1L);
    }

    /**
     * Method under test: {@link ProductController#getAllProductsBYUserId(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAllProductsBYUserId() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new ProductController()).getAllProductsBYUserId(1L);
    }

    /**
     * Method under test: {@link ProductController#deleteProduct(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteProduct() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new ProductController()).deleteProduct(1L);
    }

    /**
     * Method under test: {@link ProductController#getProductById(long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetProductById2() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

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
    void testUpdateProduct() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        ProductController productController = new ProductController();
        productController.updateProduct(1L, new Product());
    }

    /**
     * Method under test: {@link ProductController#updateProduct(long, Product)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateProduct2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        (new ProductController()).updateProduct(1L, mock(Product.class));
    }

    /**
     * Method under test: {@link ProductController#updateProduct(long, Product)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateProduct3() throws Exception {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

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
        User user = new User(1L, "F Name", "L Name", "jane.doe@example.org", "iloveyou", "Roles");

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

