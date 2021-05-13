package com.squadatena.wishlist.model;

import javax.persistence.*;

@Entity
@Table(name = "wishlist")

public class WishList{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn (name = "idclient")
    private Client client;

    @OneToOne
    @JoinColumn (name = "idproduct")
    private Product product;

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

}
