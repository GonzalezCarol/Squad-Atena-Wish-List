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

        Optional<Client> clientGivenId = clientService.searchById(id_cliente);
        Optional<Product> productGivenId = productService.findById(id_product);
        Optional<WishList> wishListSearch = wishlistService.wishListByCId(id_cliente);

        // Enter here if already exist a wishlist for a given client
        if (wishListSearch.isPresent()) {
            wishListSearch.get().setClient(clientGivenId.get());

            // Check if there are already 20 products
            if (wishListSearch.get().getProducts().size() < 20) {
                wishListSearch.get().getProducts().add(productGivenId.get());
                wishlistService.addProduct(wishListSearch.get());
                return wishListSearch.get();
            } else {
                return null;
            }

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

            //Remove the product from the list given a product ID
            for (Product pro : productList) {
                if (pro.getId().equals(id_product)) {
                    productList.remove(pro);
                    break;
                }
            }

            //Save the updated wishlist
            wishListSearch.get().setProducts(productList);
            wishlistService.saveUpdateProduct(wishListSearch.get());
            return wishListSearch.get();
        }
        return null;
    }

    // Find a product in a given client wishlist by the product name
    @GetMapping("/find/{id_cliente}")
    public Product findProductWishlist(@RequestBody String nameProduct, @PathVariable Long id_cliente) {

        Optional<WishList> wishListSearch = wishlistService.wishListByCId(id_cliente);

        // Enter here if already exist a wishlist for a given client ID
        if (wishListSearch.isPresent()) {
            List<Product> productList = wishListSearch.get().getProducts();

            // Search for a product that contains the input name (No case sensitive)
            for (Product pro : productList) {
                if (pro.getName().toLowerCase(Locale.ROOT).contains(nameProduct.toLowerCase(Locale.ROOT))) {
                    return pro;
                }
            }
        }
        return null;
    }
}



