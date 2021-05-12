package com.squadatena.wishlist.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String price;
    private String rate;
    private String color;
    private String weight;
    private Long idclient;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public String getRate() { return rate; }
    public void setRate(String rate) { this.rate = rate; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getWeight() { return weight; }
    public void setWeight(String weight) { this.weight = weight; }
    public Long getIdclient() { return idclient; }
    public void setIdclient(Long idclient) { this.idclient = idclient; }
}

