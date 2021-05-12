package com.squadatena.wishlist.model;

import javax.persistence.Entity;

@Entity (name = "WishList")
//@NamedQuery(name="WishList.deleteByIdClientandIdProduct" , query="delete from WishList u where u.id_client = ?1 and u.id = ?2")

public class WishList extends Template{}
