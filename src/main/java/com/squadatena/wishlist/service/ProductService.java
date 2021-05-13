package com.squadatena.wishlist.service;


import com.squadatena.wishlist.model.Product;
import com.squadatena.wishlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService{

    @Autowired
    ProductRepository repository;

    public Product save(Product entity) {

        return repository.save(entity);
    }

    public List<Product> save(List<Product> entities) {
        return (List<Product>) repository.saveAll(entities);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }



    public Product update(Product entity, Long id) {
        Optional<Product> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}