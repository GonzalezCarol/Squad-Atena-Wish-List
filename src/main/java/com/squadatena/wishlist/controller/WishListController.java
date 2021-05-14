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
    public Optional<WishList> index(@PathVariable Long id_cliente){
        return wishlistService.wishListById(id_cliente);
    }

    @PostMapping("/add/{id_cliente}")
    public WishList addVenda(@RequestBody Long id_product, @PathVariable Long id_cliente) {

        Optional<Client> clientGivenId = clientService.searchById(id_cliente);
        Optional<Product> productGivenId = productService.findById(id_product);
        Optional<WishList> wishListSearch = wishlistService.wishListById(id_cliente);

        List<Product> productToAdd = new ArrayList<Product>();
        productToAdd.add(productGivenId.get());

        WishList wishList = new WishList();
        wishList.setClient(clientGivenId.get());
        wishList.setProducts(productToAdd);

        return wishList;
        }
}





