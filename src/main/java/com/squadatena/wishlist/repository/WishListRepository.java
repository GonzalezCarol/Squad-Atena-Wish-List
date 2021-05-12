package com.squadatena.wishlist.repository;

import com.squadatena.wishlist.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface WishListRepository extends JpaRepository<WishList,Long> {

//    void removeByIdAndIdclient(Long id, Long idclient);
//    List<WishList> deleteById_clientAndId(Long id_client,Long id);
//
//    @Modifying
//    @Query(value = "delete from WishList u where u.idclient=?1 and u.id=?2")
//    List<WishList> deleteWishListProducts(@Param("id") Long id,@Param("idclient") Long idclient);

    @Query(value = "select u from WishList u where u.idclient = ?1")
    List<WishList> findByIdClient(Long idclient);

    @Transactional
    @Modifying
    void deleteByIdAndIdclient(Long id, Long idclient);


    WishList findByNameAndIdclient(String name, Long idclient);

}

