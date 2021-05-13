package com.squadatena.wishlist.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String cpf;

    @Column
    @NotNull
    private String address;



    public Long getId() { return id; }
    public void setIdclient(Long id_client) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

}
