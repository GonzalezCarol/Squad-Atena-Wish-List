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

        Optional<Client> clientGivenId = clientService.searchById(id_cliente);
        Optional<Product> productGivenId = productService.findById(id_product);
        Optional<WishList> wishListSearch = wishlistService.wishListByCId(id_cliente);

        // Enter here if already exist a wishlist for a given client
        if (wishListSearch.isPresent()) {
            wishListSearch.get().setClient(clientGivenId.get());
            wishListSearch.get().getProducts().add(productGivenId.get());
            wishlistService.addProduct(wishListSearch.get());
            return wishListSearch.get();

            // Enter here if there is no wishlist for a given client
        } else {
            WishList wishList = new WishList();
            List<Product> productToAdd = new ArrayList<Product>();
            productToAdd.add(productGivenId.get());
            wishList.setClient(clientGivenId.get());
            wishList.setProducts(productToAdd);
            wishlistService.addProduct(wishList);
            return wishList;
        }
    }

    // Delete a product in a given client wishlist
    @DeleteMapping("/delete/{id_cliente}")
    public WishList deleteProductWishlist(@RequestBody Long id_product, @PathVariable Long id_cliente) {

        Optional<WishList> wishListSearch = wishlistService.wishListByCId(id_cliente);

        // Enter here if already exist a wishlist for a given client
        if (wishListSearch.isPresent()) {
            List<Product> productList = wishListSearch.get().getProducts();
            for (Product pro : productList) {
                if (pro.getId().equals(id_product)) {
                    productList.remove(pro);
                    break;
                }
            }
            wishListSearch.get().setProducts(productList);
            wishlistService.addProduct(wishListSearch.get());
            return wishListSearch.get();
        }
        return null;
    }
}


