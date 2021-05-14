package com.squadatena.wishlist.service;

import com.squadatena.wishlist.entity.Client;
import com.squadatena.wishlist.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Add a client in the database
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    // List all clients in the database
    public List<Client> clientList() {
        return (List<Client>) clientRepository.findAll();
    }

    // Find a client by a given id
    public Optional<Client> searchById(Long id) {
        return clientRepository.findById(id);
    }

    // Update the client data by a given client
    public  Client updateClient(Client client){
        return clientRepository.save(client);
    }

    // Count how many clients were added in the database
    public Long clientQuantity() {
        return clientRepository.count();
    }
}
