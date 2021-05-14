package com.squadatena.wishlist.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wishlist")

public class WishList{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn (name = "idclient")
    private Client client;

    @OneToMany
    private List<Product> products;

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
    
}
