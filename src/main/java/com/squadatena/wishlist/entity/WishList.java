package com.squadatena.wishlist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/* Create a table called wishlist with 3 columns where client has a relation one to one with the table clients and products
has a relation one to many with the table products */

@Data
@Entity
@Table(name = "wishlist")

@JsonIgnoreProperties(ignoreUnknown = true)
public class WishList{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn (name = "idclient")
    private Client client;

//    @OneToMany
    @ManyToMany
    @JoinTable(
            name = "productList",
            joinColumns = @JoinColumn(name = "wishlist_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> products;
    public List<Product> getProducts() {
        return products;
    }

}
