package com.squadatena.wishlist.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

//Create a table called client with 4 columns
@Data
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

}
