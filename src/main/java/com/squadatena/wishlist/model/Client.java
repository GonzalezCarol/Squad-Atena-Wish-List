package com.squadatena.wishlist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Client")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    private String name;
    private String cpf;
    private String address;


    public Long getId_client() { return id_client; }
    public void setId_client(Long id_client) { this.id_client = id_client; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

}
