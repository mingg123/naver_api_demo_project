package com.example.recomendShopping.naver;

import com.example.recomendShopping.naver.dto.SearchReq;
import com.example.recomendShopping.naver.dto.SearchRes;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.var;

@Component
public class NaverClient {
    
    private String naverClientId = "2lWzsgurEbA9GM8DhY7s";

    private String naverSecretId = "nGRNN_CStH";

    private String getShoppingUrl = "https://openapi.naver.com/v1/search/shop.json";


    //요청
    public SearchRes getShops(SearchReq searchReq) {
        var uri = UriComponentsBuilder.fromUriString(getShoppingUrl)
        .queryParams(searchReq.toMultiValueMap())
        .build()
        .encode()
        .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverSecretId);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchRes>(){};

        var responseEntity = new RestTemplate().exchange(
            uri,
            HttpMethod.GET,
            httpEntity,
        responseType);

        return responseEntity.getBody(); 
    }
}
