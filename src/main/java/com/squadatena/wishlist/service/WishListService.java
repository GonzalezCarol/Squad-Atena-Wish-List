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
    private ProductRepository productRepository;

    // Find a wishlist by a given client Id
    public Optional<WishList> wishListByCId(Long id) throws Exception{

        Optional<WishList> wishListSearch = wishListRepository.findByClientId(id);

        // Check if there a client registered with the id
        if (wishListSearch.isPresent()) {
            return wishListRepository.findByClientId(id);
        } else {
            throw new Exception("There is no client registered with this id");
        }
    }

    // Add a product in a given client wishlist
    public WishList addProduct(Long id_cliente, Long id_product) throws Exception {

        Optional<Client> clientGivenId = clientRepository.findById(id_cliente);
        Optional<Product> productGivenId = productRepository.findById(id_product);
        Optional<WishList> wishListSearch = wishListRepository.findByClientId(id_cliente);

        // Check if there a product registered with the id
        if (productGivenId.isPresent()) {

            // Check if there a client registered with the id
            if (clientGivenId.isPresent()) {

                // Enter here if already exist a wishlist for a given client
                if (wishListSearch.isPresent()) {
                    wishListSearch.get().setClient(clientGivenId.get());

                    // Check if there are already 20 products
                    if (wishListSearch.get().getProducts().size() < 20) {
                        wishListSearch.get().getProducts().add(productGivenId.get());
                        wishListRepository.save(wishListSearch.get());
                        return wishListSearch.get();
                    } else {
                        throw new Exception("You have reach the maximum number of products allowed for the wishlist");
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
            } else {
                throw new Exception("There is no client registered with this id");
            }
        } else {
            throw new Exception("There is no product registered with this id");
        }
    }

    // Delete a product in a given client wishlist
    public WishList deleteProduct(Long id_cliente, Long id_product) throws Exception{
        Optional<WishList> wishListSearch = wishListRepository.findByClientId(id_cliente);

        // Enter here if already exist a wishlist for a given client
        if (wishListSearch.isPresent()) {
            List<Product> productList = wishListSearch.get().getProducts();

            //Remove the product from the list given a product ID
            boolean ok = false;
            for (Product pro : productList) {
                if (pro.getId().equals(id_product)) {
                    productList.remove(pro);
                    ok = true;
                    break;
                }
            }

            // Return a message if there is no product id
            if (!ok){
                throw new Exception("You do not have this product id in the wishlist");
            }

            //Set the updated product list
            wishListSearch.get().setProducts(productList);

            //Save the updated wishlist
            return wishListRepository.save(wishListSearch.get());

            // Return a message if there is no client id
        }else {
            throw new Exception("There is no client registered with this id");
        }
    }

    // Find a product in a given client wishlist by the product name
    public Product productInAWishList(Long id_cliente, String nameProduct) throws Exception {

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

            // Return a message if there is no product name that contains the word inputted
            throw new Exception("You do not have this product in the wishlist");

            // Return a message if there is no client id
        } else {
            throw new Exception("There is no client registered with this id");
        }
    }
}
