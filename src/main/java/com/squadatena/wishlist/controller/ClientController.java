package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.entity.Client;
import com.squadatena.wishlist.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController

public class ClientController {

    @Autowired
    private ClientService clientService;

    // List the clients in the database
    @GetMapping(value = "/client")
    public List<Client> index(){
        return clientService.clientList();
    }

    // Find a client by a given id
    @GetMapping(value = "/client/{id}")
    public Optional<Client> selectByID(@PathVariable Long id) {
        return clientService.searchById(id);
    }

    // Add a client in the database
    @PostMapping(value = "/client")
    public Client addClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return client;
    }

    // Update a client by a given id
    @PutMapping(value = "/client/{id}")
    public Client updateAClient (@PathVariable Long id, @RequestBody Client client){
        Optional<Client> clientAfterSearch = clientService.searchById(id);
            if (clientAfterSearch.isPresent()) {
                client.setId(clientAfterSearch.get().getId());
                return clientService.updateClient(client);
            }
            return null;
        }

}


