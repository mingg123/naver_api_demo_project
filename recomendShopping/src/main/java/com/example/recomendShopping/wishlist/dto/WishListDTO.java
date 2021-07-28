package com.example.recomendShopping.wishlist.dto;

import com.example.recomendShopping.db.MemoryDbEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishListDTO extends MemoryDbEntity {

    private String title;
    private String link;
    private String image;
    private int Iprice;
    private int hprice;
    private String mallName;
    private String productId;
    private int productType;
    private String maker;
    private String brand;
    private String category1;
    private String category2;
    private String category3;
    private String category4;

}
