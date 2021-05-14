package com.squadatena.wishlist.repository;

import com.squadatena.wishlist.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

//Create the communication with the database for wishlist table

public interface WishListRepository extends JpaRepository<WishList,Long> {

    //Derived query to search the wishlist table by Client Id
    Optional<WishList> findByClientId (Long id);

}

