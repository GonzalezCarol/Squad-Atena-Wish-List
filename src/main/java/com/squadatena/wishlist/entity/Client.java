package com.squadatena.wishlist.entity;

import javax.persistence.*;
import java.io.Serializable;

//Create a table called client with 4 columns
@Entity
@Table(name = "client")

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, length = 14)
    private String cpf;

    @Column(nullable=false)
    private String address;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
