package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.entity.Client;
import com.squadatena.wishlist.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/client")
@RestController

public class ClientController {

    @Autowired
    private ClientService clientService;

    // List the clients in the database
    @GetMapping
    public List<Client> index(){
        return clientService.clientList();
    }

    // Find a client of a given id
    @GetMapping(value = "/{id}")
    public Optional<Client> selectByID(@PathVariable Long id) {
        return clientService.searchById(id);
    }

    // Add a client in the database
    @PostMapping
    public Client addClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return client;
    }

    // Update a client of a given id
    @PutMapping(value = "/{id}")
    public Client updateAClient (@PathVariable Long id, @RequestBody Client client){
        Optional<Client> clientAfterSearch = clientService.searchById(id);
            if (clientAfterSearch.isPresent()) {
                client.setId(clientAfterSearch.get().getId());
                return clientService.updateClient(client);
            }
            return null;
        }

    // Count the number of clients in the database
    @GetMapping("/getNumberOfClients")
    public Long numberOfClients(){
        return clientService.clientQuantity();
    }


}


