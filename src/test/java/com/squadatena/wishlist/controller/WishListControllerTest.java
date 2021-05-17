package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.model.Product;
import com.squadatena.wishlist.model.WishList;
import com.squadatena.wishlist.service.WishListService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class WishListControllerTest {

    @Autowired
    WishListService wishListService;

    @Test
    void incluirProdutoWishList(){

         //Adicionar produto na wishlist de um determinado cliente
         //Deletar produto da wishlist de um determinado cliente
        //Buscar produtos na wishlist de um determinado cliente

        //Preciso de adicionar o produto na wishlist
        WishList wishlist = new WishList();
        WishListService wishlistservice;
        wishlistservice.getWishListToAdd(wishlist,product,id_cliente);
        wishlistservice.saveProductWishList(wishlist);
        
        Product product = productService.findById(id).orElse(null);
        WishList wishlist = new WishList();
        wishlistservice.getWishListToAdd(wishlist,product,id_cliente);
        wishlistservice.saveProductWishList(wishlist);
        
        //Quando o produto for salvo como favorito
        WishList saveProductWishList = wishlistservice.saveProductWishList(wishlist);


        //Resultado
        assertThat(saveProductWishList).isNotNull();

    }
    //Buscar um produto na wishlist de um determinado cliente

    @Test
    void buscarProdutoPorId(){

        //Preciso de adicionar o produto na wishlist
        WishList wishlist = new WishList();
        WishListService wishlistservice;
        wishlist.getIdclient("");
        wishlist.getId("");

        //Quando o produto for salvo como favorito
        WishList saveProduct = wishlistservice.saveProductWishList(wishlist);

        //Resultado esperado é buscar o produto na whishlist e encontrar
        assertThat(saveProduct.getId()).isEqualTo(1);

    }

    @Test
    void deleteProductWishList(){

    }
}
