package com.squadatena.wishlist.service;

import com.squadatena.wishlist.model.Client;
import com.squadatena.wishlist.model.Product;
import com.squadatena.wishlist.model.WishList;
import com.squadatena.wishlist.repository.ClientRepository;
import com.squadatena.wishlist.repository.ProductRepository;
import com.squadatena.wishlist.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service

public class WishListService {

    Client client;

    @Autowired
    private WishListRepository wishlistrepository;

    @Autowired
    private ClientRepository clientrepository;

    @Autowired
    ProductRepository productRepository;


    public List<WishList> wishlistList(Long id) {
        return wishlistrepository.findByClientId(id); }

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