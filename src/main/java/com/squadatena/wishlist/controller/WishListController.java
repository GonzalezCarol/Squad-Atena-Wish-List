package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.entity.Client;
import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.entity.WishList;
import com.squadatena.wishlist.service.ClientService;
import com.squadatena.wishlist.service.ProductService;
import com.squadatena.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    // Find a wishlist from a given client Id
    @GetMapping("/{id_cliente}")
    public Optional<WishList> index(@PathVariable Long id_cliente) {
        return wishlistService.wishListByCId(id_cliente);
    }

    // Add a product in a given client wishlist
    @PostMapping("/add/{id_cliente}")
    public WishList addProductWishlist(@RequestBody Long id_product, @PathVariable Long id_cliente) {
        return wishlistService.addProduct(id_cliente, id_product);
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



