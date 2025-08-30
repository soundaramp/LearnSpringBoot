package com.learn.spring.service.impl;

import com.learn.spring.model.Product;
import com.learn.spring.repository.ProductRepository;
import com.learn.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updateProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            product.setProductCount(updateProduct.getProductCount());
            return productRepository.save(product);
        }).orElseThrow(()-> new RuntimeException("Product is not found with id "+id));
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

