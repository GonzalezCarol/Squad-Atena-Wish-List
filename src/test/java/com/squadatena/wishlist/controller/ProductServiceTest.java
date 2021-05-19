package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.repository.ProductRepository;
import com.squadatena.wishlist.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)

public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;


    //Salvar produto
    @Test
    public void setProductService(){

        //Preciso Salvar um produto
        Product product = new Product();
        product.setName("Bolsa Santa Lola de Couro Marrom");
        product.setColor("Marrom");
        product.setDescription("Bolsa Santa Lola de Couro Marrom");
        BigDecimal a = new BigDecimal("200.50");
        product.setPrice(a);
        product.setRate(20.5);
        product.setUrl("https://secure-static.arezzo.com.br/medias/sys_master/arezzo/arezzo/h4e/h77/h00/h00/9865733799966/5002304520027U-HO-BASEIMAGE-Midres.jpg");
        product.setWeight(1.6);

        //Quando o produto for salvo
        Product saveProduct = productService.save(product);

        //Resultado é não vazio
        assertThat(saveProduct).isNotNull();
        assertThat(saveProduct.getId()).isNotNull();
        assertThat(saveProduct.getName()).isEqualTo("Bolsa Santa Lola de Couro Marrom");
        assertThat(saveProduct.getColor()).isEqualTo("Marrom");
        assertThat(saveProduct.getRate()).isEqualTo(20.5);
        assertThat(saveProduct.getUrl()).isEqualTo("https://secure-static.arezzo.com.br/medias/sys_master/arezzo/arezzo/h4e/h77/h00/h00/9865733799966/5002304520027U-HO-BASEIMAGE-Midres.jpg");
        assertThat(saveProduct.getWeight()).isEqualTo(1.6);
        assertThat(saveProduct.getPrice()).isEqualTo(a);




    }
    //Buscar lista de produtos
    @Test
    public void findAllProduct(){

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
        productService.deleteById(saveProduct.getId());
        assertThat(productService.findAll()).isEmpty();

    }

    // Buscar produto pelo ID
    @Test
    public void findByIDProduct(){

        //Quando buscar o produto
        Optional<Product> searchProduct = productService.findById(1L);

        if (searchProduct.isPresent()) {

            //Resultado retornar produto buscado pelo id
            assertThat(productService.findById(1L)).isEqualTo(searchProduct);
        }

    }

    //Deletar produto
    @Test
    public void deleteProduct(){

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
        productService.deleteById(saveProduct.getId());
        assertThat(productService.findById(saveProduct.getId())).isNotNull();

    }
    @Test
    public void updateProduct() {
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

        Product product1 = new Product();
        product1.setName("change");
        product1.setColor("b");
        product1.setDescription("s");
        BigDecimal b = new BigDecimal("10.50");
        product1.setPrice(b);
        product1.setRate(1.5);
        product1.setUrl("ag");
        product1.setWeight(10.6);
        Product saveProduct1 = productService.update(product1, product.getId());

        assertThat(saveProduct1.getName()).isEqualTo("change");


    }


}
