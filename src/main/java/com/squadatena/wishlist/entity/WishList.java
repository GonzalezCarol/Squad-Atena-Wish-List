package com.squadatena.wishlist.entity;

import javax.persistence.*;
import java.util.List;

/* Create a table called wishlist with 3 columns where client has a relation one to one with the table clients and products
has a relation one to many with the table products */

@Entity
@Table(name = "wishlist")

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
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
