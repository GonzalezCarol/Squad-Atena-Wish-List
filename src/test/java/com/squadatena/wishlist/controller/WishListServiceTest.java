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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest

@RunWith(SpringRunner.class)

public class WishListServiceTest {

    @Autowired
    WishListService wishListService;

    @Autowired
    ClientService clientService;

    @Autowired
    ProductService productService;

    //Save Client
    @Transactional
    @Test
    public void addWishList() throws Exception {

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

        WishList wishList = wishListService.addProduct(1L, 1L);

        assertThat(wishList.getClient()).isEqualTo(saveClient);
        assertThat(wishList.getProducts().get(0)).isEqualTo(saveProduct);
    }

    @Transactional
    @Test
    public void findWishListByCId() throws Exception {

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

        WishList wishList = wishListService.addProduct(1L, 1L);

        Optional<WishList> wishList1 = wishListService.wishListByCId(1L);

        assertThat(wishList1.get().getClient().getId()).isEqualTo(wishList.getClient().getId());
    }

    @Transactional
    @Test
    public void deleteWishList() throws Exception {

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

        WishList wishList = wishListService.addProduct(1L, 1L);

        WishList wishList1 = wishListService.deleteProduct(1L,1L);

        assertThat(wishList1.getProducts()).isEmpty();
    }

    @Transactional
    @Test
    public void findByName() throws Exception {

        Client client = new Client();
        client.setName("Poliana Pereira Andrade");
        client.setCpf("07249755609");
        client.setAddress("Rua Ovideo Bradamante Toledo");

        Client saveClient = clientService.saveClient(client);

        Product product = new Product();
        product.setName("Skate Fancy");
        product.setColor("b");
        product.setDescription("s");
        BigDecimal a = new BigDecimal("10.50");
        product.setPrice(a);
        product.setRate(1.5);
        product.setUrl("ag");
        product.setWeight(10.6);
        Product saveProduct = productService.save(product);

        WishList wishList = wishListService.addProduct(1L, 1L);

        Product product1 = wishListService.productInAWishList(1L,"ancy");

        assertThat(product1.getName()).isEqualTo("Skate Fancy");
    }
}