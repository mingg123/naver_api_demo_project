package com.example.recomendShopping.wishlist.repository;

import com.example.recomendShopping.db.MemoryDbRepositoryAbstract;
import com.example.recomendShopping.wishlist.dto.WishListDTO;
import com.example.recomendShopping.wishlist.entity.WishListEntity;

import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
    
}
