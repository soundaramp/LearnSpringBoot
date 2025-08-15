package com.learn.spring.service;

import com.learn.spring.model.Product;
import com.learn.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts() ;
    public Optional<Product> getProductById(Long id) ;

    public Product saveProduct(Product product) ;
    public Product updateProduct(Long id, Product updateProduct);
    public void deleteProduct(Long id) ;
}
