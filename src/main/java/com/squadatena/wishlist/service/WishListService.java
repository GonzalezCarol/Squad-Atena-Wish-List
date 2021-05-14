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

    // Add a product in a given wishlist
    public WishList addProduct(WishList wishList) {

        return wishListRepository.save(wishList);
    }


//    public void saveProductWishList (WishList wishlist){
//        wishlistrepository.save(wishlist);}
//
//    public WishList getWishListToAdd (WishList wishlist, Long id, Long idcliente){
//
////        wishlist.setName(product.getName());
////        wishlist.setPrice(product.getPrice());
////        wishlist.setColor(product.getColor());
////        wishlist.setDescription(product.getDescription());
//        wishlist.setClient(clientrepository.findById(idcliente).get());
//        wishlist.setProduct(productRepository.findById(id).get());
////        wishlist.setRate(product.getRate());
////        wishlist.setWeight(product.getWeight());
//
//        return wishlist; }
//
//    public void wishListDelete(Long id, Long idclient) {
//        wishlistrepository.deleteByIdAndIdclient(id, idclient); }
//
//    public WishList getWishListByName(String name, Long idclient) {
//        return wishlistrepository.findByNameAndIdclient(name.toLowerCase(Locale.ROOT), idclient); }

}