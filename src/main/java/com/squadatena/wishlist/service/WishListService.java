package com.squadatena.wishlist.service;

import com.squadatena.wishlist.model.Product;
import com.squadatena.wishlist.model.WishList;
import com.squadatena.wishlist.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service

public class WishListService {

    @Autowired
    private WishListRepository wishlistrepository;


    public List<WishList> wishlistList(Long idclient) {
        return wishlistrepository.findByIdClient(idclient); }

    public void saveProductWishList (WishList wishlist){
        wishlistrepository.save(wishlist);}

    public WishList getWishListToAdd (WishList wishlist, Product product, Long idcliente){

        wishlist.setName(product.getName());
        wishlist.setPrice(product.getPrice());
        wishlist.setColor(product.getColor());
        wishlist.setDescription(product.getDescription());
        wishlist.setIdclient(idcliente);
        wishlist.setRate(product.getRate());
        wishlist.setWeight(product.getWeight());

        return wishlist; }

    public void wishListDelete(Long id, Long idclient) {
        wishlistrepository.deleteByIdAndIdclient(id, idclient); }

    public WishList getWishListByName(String name, Long idclient) {
        return wishlistrepository.findByNameAndIdclient(name.toLowerCase(Locale.ROOT), idclient); }

}