package com.shubham.swapsie.service.impl;

import com.shubham.swapsie.exception.ResourceNotFoundException;
import com.shubham.swapsie.model.Product;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.repository.ProductRepository;
import com.shubham.swapsie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Product with id : "+id+" does not exist"));
        return product;
    }

    @Override
    public List<Product> getAllProductsByUserId(long user_id) {
        List<Product> productList = productRepository.findAllByUserId(user_id);
//        if(product == null)
//            throw new RuntimeException("Did not find any product for this user ");
        return productList;
    }

}
