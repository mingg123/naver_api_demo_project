package com.example.recomendShopping.naver;

import com.example.recomendShopping.naver.dto.SearchReq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.var;

@SpringBootTest
public class NaverClientTest {
    
    @Autowired
    private NaverClient naverClient;

    @Test
    public void getShops () {
        var search = new SearchReq();
        search.setQuery("복숭아");

        var result = naverClient.getShops(search);
        System.out.println(result);
    }
}
