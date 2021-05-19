package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController

public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping(value = "/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id).orElse(null);}

    @DeleteMapping(value = "/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        productService.deleteById(id); }

    @GetMapping(value = "/product")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> list() {
        return productService.findAll();
    }

    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product update(@RequestBody Product product, @PathVariable("id") Long id) {
        return product;
    }
}