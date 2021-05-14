package com.squadatena.wishlist.service;

import com.squadatena.wishlist.entity.Client;
import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.entity.WishList;
import com.squadatena.wishlist.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service

public class WishListService {

    WishList wishList;

    @Autowired
    private WishListRepository wishListRepository;

    // Find a wishlist from a given client Id
    public Optional<WishList> wishListByCId(Long id) {
        return wishListRepository.findByClientId(id);
    }

    // Add a product in a given client wishlist
    public WishList addProduct(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    // Delete a product in a given client wishlist
    public void deleteProduct(WishList wishList) {
        wishListRepository.delete(wishList);
    }



}