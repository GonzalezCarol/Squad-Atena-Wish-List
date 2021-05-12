package com.squadatena.wishlist.service;


import com.squadatena.wishlist.model.Client;
import com.squadatena.wishlist.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientService {

    @Autowired
    private ClientRepository clientrepository;

    public void saveClient (Client client){
        clientrepository.save(client); }

    public List<Client> clientList(){
        return (List<Client>) clientrepository.findAll(); }

    public Optional<Client> findById(Long id){
        return clientrepository.findById(id); }
}
