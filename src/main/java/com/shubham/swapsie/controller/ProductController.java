package com.shubham.swapsie.controller;

import com.shubham.swapsie.model.Product;
import com.shubham.swapsie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("getProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<Product>> getAllProductsBYUserId(@PathVariable long user_id){
        List<Product>  productList = productService.getAllProductsByUserId(user_id);
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        return productService.deleteProduct(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product product){
        Product updatedProduct = productService.updateProduct(id, product);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

}
