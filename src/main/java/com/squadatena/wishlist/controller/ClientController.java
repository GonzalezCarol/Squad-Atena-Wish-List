package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.model.Client;
import com.squadatena.wishlist.service.ClientService;
import com.squadatena.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ClientController {

    public Long id_client;

//    public Long getId_client() { return id_client; }
//    public void setId_client(Long id_client) { this.id_client = id_client; }


    @Autowired
    private ClientService clientservice;
    private WishListService wishlistservice;

    @GetMapping("/client")
    public List<Client> index(){
        return clientservice.clientList();
    }

    @GetMapping(value = "/client/{id}")
    public Client findbyID(@PathVariable ("id") Long id) {
        id_client = id;
        return clientservice.findById(id).orElse(null); }

    @PostMapping("/client")
    public Client addClient(@RequestBody Client client) {
        clientservice.saveClient(client);
        return client; }
}