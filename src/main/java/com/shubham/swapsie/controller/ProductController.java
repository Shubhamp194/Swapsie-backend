package com.shubham.swapsie.controller;

import com.shubham.swapsie.model.Product;
import com.shubham.swapsie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    private static final Logger logger = LogManager.getLogger(ProductController.class);

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        logger.info("New Product Added");
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("getProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        logger.info("All Products requested");
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        Product product = productService.getProductById(id);
        logger.info("Specific Product requested using id");
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<Product>> getAllProductsBYUserId(@PathVariable long user_id){
        List<Product>  productList = productService.getAllProductsByUserId(user_id);
        logger.info("All Products requested belonging to a particular user");
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        logger.info("Product delete request initiated");
        return productService.deleteProduct(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product product){
        Product updatedProduct = productService.updateProduct(id, product);
        logger.info("Product update request initiated");
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

}
