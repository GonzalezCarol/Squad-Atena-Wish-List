package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.dto.ProductDTO;
import com.squadatena.wishlist.mapper.ProductMapper;
import com.squadatena.wishlist.model.Product;
import com.squadatena.wishlist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
//Silvia
@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.asEntity(productDTO);
        return productMapper.asDTO(productService.save(product));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO findById(@PathVariable("id") Long id) {
        Product product = productService.findById(id).orElse(null);
        return productMapper.asDTO(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> list() {
        return productMapper.asDTOList(productService.findAll());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO update(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
        Product product = productMapper.asEntity(productDTO);
        return productMapper.asDTO(productService.update(product, id));
    }
}