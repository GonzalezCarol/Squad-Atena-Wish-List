package com.squadatena.wishlist.repository;

import com.squadatena.wishlist.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Create the communication with the database for Client table

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {}
