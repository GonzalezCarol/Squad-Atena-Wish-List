package com.squadatena.wishlist.entity;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "product")

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String description;

    @Column
    @NotNull
    private BigDecimal price;

    @Column
    @NotNull
    private BigDecimal rate;

    @Column
    @NotNull
    private String color;

    @Column
    @NotNull
    private BigDecimal weight;

    @Column
    @NotNull
    @Size(min = 0, max = 500)
    private String url;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public BigDecimal getRate() { return rate; }
    public void setRate(BigDecimal rate) { this.rate = rate; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}

