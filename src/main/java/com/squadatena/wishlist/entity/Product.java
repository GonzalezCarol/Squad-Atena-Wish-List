package com.squadatena.wishlist.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

//Create a table called product with 8 columns
@Entity
@Table(name = "product")

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Double getRate() { return rate; }
    public void setRate(Double rate) { this.rate = rate; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}

