package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.entity.Client;
import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.entity.WishList;
import com.squadatena.wishlist.service.ClientService;
import com.squadatena.wishlist.service.ProductService;
import com.squadatena.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RequestMapping("/wishlist")
@RestController

public class WishListController {


    @Autowired
    private WishListService wishlistService;

    // Find a wishlist from a given client Id
    @GetMapping("/{id_cliente}")
    public ResponseEntity<?> index(@PathVariable Long id_cliente) {
        try {
            return new ResponseEntity<>(wishlistService.wishListByCId(id_cliente), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a product in a given client wishlist
    @PostMapping("/add/{id_cliente}")
    public ResponseEntity<?> addProductWishlist(@RequestBody Long id_product, @PathVariable Long id_cliente) {
        try {
            WishList wishListAnwser = wishlistService.addProduct(id_cliente, id_product);
            return new ResponseEntity<>(wishListAnwser, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // Delete a product in a given client wishlist
    @DeleteMapping("/delete/{id_cliente}")
    public WishList deleteProductWishlist(@RequestBody Long id_product, @PathVariable Long id_cliente) {
        return wishlistService.deleteProduct(id_cliente, id_product);
    }

    // Find a product in a given client wishlist by the product name
    @GetMapping("/find/{id_cliente}")
    public Product findProductWishlist(@RequestBody String nameProduct, @PathVariable Long id_cliente) {
        return wishlistService.productInAWishList(id_cliente,nameProduct);
    }

}



