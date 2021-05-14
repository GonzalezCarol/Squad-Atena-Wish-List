package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.entity.WishList;
import com.squadatena.wishlist.service.ClientService;
import com.squadatena.wishlist.service.ProductService;
import com.squadatena.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class WishListController {


    @Autowired
    private WishListService wishlistService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/wishlist/{id_cliente}")
    public List<WishList> index(@PathVariable("id_cliente") Long id_cliente){
//        Client client = clientservice.findById(id_cliente).get();
        return wishlistService.wishlistList(id_cliente); }

//    @PostMapping(value = "/save_wish_list/{id_cliente}")
//    public WishList wishSave (@RequestBody Long id,@PathVariable("id_cliente") Long id_cliente){
//
//        Product product = productService.findById(id).orElse(null);
//        WishList wishlist = new WishList();
//        wishlistservice.getWishListToAdd(wishlist,id,id_cliente);
//        wishlistservice.saveProductWishList(wishlist);
//
//        return wishlist; }
//
//    @DeleteMapping(value = "/delete_wish_list/{idcliente}")
//    public void deleteWishList(@RequestBody Long id,@PathVariable("idcliente") Long idcliente) {
//         wishlistservice.wishListDelete(id,idcliente);
//    }
//
//    @GetMapping(value = "/get_wish_list_byProductName/{idcliente}")
//    public WishList deleteWishList(@RequestBody String name, @PathVariable("idcliente") Long idcliente) {
//        return wishlistservice.getWishListByName(name,idcliente);
//        }
//
//
}
