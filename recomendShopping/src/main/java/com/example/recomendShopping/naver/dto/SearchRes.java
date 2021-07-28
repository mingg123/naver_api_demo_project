package com.example.recomendShopping.naver.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRes {
    
    private String lastBuildDate;
    private int total;
    private int start;
    private int display;

    private List<SearchItem> items;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchItem {
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

}
