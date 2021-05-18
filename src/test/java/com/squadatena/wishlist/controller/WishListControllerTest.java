package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.entity.Client;
import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.entity.WishList;
import com.squadatena.wishlist.service.ClientService;
import com.squadatena.wishlist.service.ProductService;
import com.squadatena.wishlist.service.WishListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)

public class WishListControllerTest {

    @Autowired
    WishListService wishListService;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

    //Salvar Cliente
    @Test
    public void addWishList() throws Exception {

        //Preciso de salvar um novo produto na wishlist no banco

        Client client = new Client();
        client.setName("Poliana Pereira Andrade");
        client.setCpf("07249755609");
        client.setAddress("Rua Ovideo Bradamante Toledo");

        Client saveClient = clientService.saveClient(client);

        Product product = new Product();
        product.setName("a");
        product.setColor("b");
        product.setDescription("s");
        BigDecimal a = new BigDecimal("10.50");
        product.setPrice(a);
        product.setRate(1.5);
        product.setUrl("ag");
        product.setWeight(10.6);
        Product saveProduct = productService.save(product);

        WishList wishList = wishListService.addProduct(1L,1L);
        //Resultado não é vazio
        assertThat(wishList.getClient()).isEqualTo(saveClient);
        assertThat(wishList.getProducts().get(0)).isEqualTo(saveProduct);
    }
}
