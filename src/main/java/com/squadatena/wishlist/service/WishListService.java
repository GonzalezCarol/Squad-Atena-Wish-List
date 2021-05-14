package com.squadatena.wishlist.service;

import com.squadatena.wishlist.entity.Client;
import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.entity.WishList;
import com.squadatena.wishlist.repository.ClientRepository;
import com.squadatena.wishlist.repository.ProductRepository;
import com.squadatena.wishlist.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service

public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    // Find a wishlist by a given client Id
    public Optional<WishList> wishListByCId(Long id) {
        return wishListRepository.findByClientId(id);
    }

    // Add a product in a given client wishlist
    public WishList addProduct(Long id_cliente, Long id_product) {

        Optional<Client> clientGivenId = clientRepository.findById(id_cliente);
        Optional<Product> productGivenId = productRepository.findById(id_product);
        Optional<WishList> wishListSearch = wishListRepository.findByClientId(id_cliente);

        // Enter here if already exist a wishlist for a given client
        if (wishListSearch.isPresent()) {
            wishListSearch.get().setClient(clientGivenId.get());

            // Check if there are already 20 products
            if (wishListSearch.get().getProducts().size() < 20) {
                wishListSearch.get().getProducts().add(productGivenId.get());
                wishListRepository.save(wishListSearch.get());
                return wishListSearch.get();
            } else {
                return null;
            }

            // Enter here if there is no wishlist for a given client
        } else {
            WishList wishList = new WishList();
            List<Product> productToAdd = new ArrayList<>();
            productToAdd.add(productGivenId.get());
            wishList.setClient(clientGivenId.get());
            wishList.setProducts(productToAdd);
            wishListRepository.save(wishList);

            return wishList;
        }
    }

    // Delete a product in a given client wishlist
    public WishList deleteProduct(Long id_cliente, Long id_product) {
        Optional<WishList> wishListSearch = wishListRepository.findByClientId(id_cliente);

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

            //Set the updated product list
            wishListSearch.get().setProducts(productList);

            //Save the updated wishlist
            return wishListRepository.save(wishListSearch.get());
        }
        return null;
    }

    // Save or update a wishlist
    public WishList saveUpdateProduct(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    // Find a product in a given client wishlist by the product name
    public Product productInAWishList(Long id_cliente, String nameProduct) {

        Optional<WishList> wishListSearch = wishListRepository.findByClientId(id_cliente);

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
