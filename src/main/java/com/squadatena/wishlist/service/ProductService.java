package com.squadatena.wishlist.service;

import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService{

    @Autowired
    ProductRepository productRepository;

    // Add a product in the database
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    // Delete a product in the database by a given id
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // Find a product in the database by a given id
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // List all products in the database
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    // Update the product data by a given client
    public Product update(Product entity, Long id) {
        Optional<Product> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}