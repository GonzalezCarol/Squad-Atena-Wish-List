package com.squadatena.wishlist.repository;


import com.squadatena.wishlist.entity.Product;
import com.squadatena.wishlist.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository

public interface WishListRepository extends JpaRepository<WishList,Long> {

//    @Query(value = "select u from wishlist u where u.idclient = ?1")
    Optional<WishList> findByClientId (Long id);



//
//    @Transactional
//    @Modifying
//    void deleteByIdAndIdclient(Long id, Long idclient);
//
//
//    WishList findByNameAndIdclient(String name, Long idclient);

}

