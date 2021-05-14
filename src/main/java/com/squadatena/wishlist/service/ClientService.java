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

    public List<Client> clientList() {

        return (List<Client>) clientRepository.findAll();
    }

    // Find a client of a given id
    public Optional<Client> searchById(Long id) {

        return clientRepository.findById(id);
    }

    // Update the data of a given client
    public  Client updateClient(Client client){

        return clientRepository.save(client);
    }

    // Count how many clients were added in the database
    public Long clientQuantity() {

        return clientRepository.count();
    }
}
