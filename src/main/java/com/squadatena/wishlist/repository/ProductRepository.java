package com.squadatena.wishlist.repository;

import com.squadatena.wishlist.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Create the communication with the database for Product table

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
