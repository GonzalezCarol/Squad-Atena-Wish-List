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

    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    public List<Product> save(List<Product> entities) {

        return (List<Product>) productRepository.saveAll(entities);
    }

    public void deleteById(Long id) {

        productRepository.deleteById(id);
    }

    public Optional<Product> findById(Long id) {

        return productRepository.findById(id);
    }

    public List<Product> findAll() {

        return (List<Product>) productRepository.findAll();
    }

    public Product update(Product entity, Long id) {
        Optional<Product> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}