package com.squadatena.wishlist.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

//Create a table called product with 8 columns

@Data
@Entity
@Table(name = "product")

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany (mappedBy = "products")
    private List<WishList> wishList;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private BigDecimal price;

    @Column(nullable=false)
    private Double rate;

    @Column(nullable=false)
    private String color;

    @Column(nullable=false)
    private Double weight;

    @Column(nullable=false, length = 500)
    private String url;
}

