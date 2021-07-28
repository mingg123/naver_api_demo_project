package com.example.recomendShopping.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.naming.spi.DirStateFactory.Result;

import com.example.recomendShopping.naver.NaverClient;
import com.example.recomendShopping.naver.dto.SearchReq;
import com.example.recomendShopping.naver.dto.SearchRes;
import com.example.recomendShopping.wishlist.dto.WishListDTO;
import com.example.recomendShopping.wishlist.entity.WishListEntity;
import com.example.recomendShopping.wishlist.repository.WishListRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;

    public final WishListRepository wishListRepository;

    public WishListDTO search(String query) {

        var searchReq = new SearchReq();
        searchReq.setQuery(query);

        var searchRes = naverClient.getShops(searchReq);

        if (searchRes.getTotal() > 0) {
            var item = searchRes
                .getItems()
                .stream()
                .findFirst()
                .get();

            var imageQuery = item
                .getTitle()
                .replaceAll("<[^>]*", "");

            var result = new WishListDTO();
            result.setTitle(item.getTitle());
            result.setLink(item.getLink());
            result.setImage(item.getImage());
            result.setIprice(item.getIprice());
            result.setHprice(item.getHprice());
            result.setMallName(item.getMallName());
            result.setProductId(item.getProductId());
            result.setProductType(item.getProductType());
            result.setMaker(item.getMaker());
            result.setBrand(item.getBrand());
            result.setCategory1(item.getCategory1());
            result.setCategory2(item.getCategory2());
            result.setCategory3(item.getCategory3());
            result.setCategory4(item.getCategory4());
            return result;
        }
        return new WishListDTO();
    }
    public WishListDTO add(WishListDTO wishListDTO) {
        var entity = dtoToEntity(wishListDTO);
        var saveEntity = wishListRepository.save(entity);
        return entityToDto(saveEntity);
    }

    public WishListEntity dtoToEntity(WishListDTO wishListDTO) {
        var entity = new WishListEntity();
        entity.setIndex(wishListDTO.getIndex());
        entity.setTitle(wishListDTO.getTitle());
        entity.setLink(wishListDTO.getLink());
        entity.setImage(wishListDTO.getImage());
        entity.setIprice(wishListDTO.getIprice());
        entity.setHprice(wishListDTO.getHprice());
        entity.setMallName(wishListDTO.getMallName());
        entity.setProductId(wishListDTO.getProductId());
        entity.setProductType(wishListDTO.getProductType());
        entity.setMaker(wishListDTO.getMaker());
        entity.setBrand(wishListDTO.getBrand());
        entity.setCategory1(wishListDTO.getCategory1());
        entity.setCategory2(wishListDTO.getCategory2());
        entity.setCategory3(wishListDTO.getCategory3());
        entity.setCategory4(wishListDTO.getCategory4());
        return entity;
    }

    public WishListDTO entityToDto(WishListEntity wishListEntity) {
        var dto = new WishListDTO();
        dto.setIndex(wishListEntity.getIndex());
        dto.setTitle(wishListEntity.getTitle());
        dto.setLink(wishListEntity.getLink());
        dto.setImage(wishListEntity.getImage());
        dto.setIprice(wishListEntity.getIprice());
        dto.setHprice(wishListEntity.getHprice());
        dto.setMallName(wishListEntity.getMallName());
        dto.setProductId(wishListEntity.getProductId());
        dto.setProductType(wishListEntity.getProductType());
        dto.setMaker(wishListEntity.getMaker());
        dto.setBrand(wishListEntity.getBrand());
        dto.setCategory1(wishListEntity.getCategory1());
        dto.setCategory2(wishListEntity.getCategory2());
        dto.setCategory3(wishListEntity.getCategory3());
        dto.setCategory4(wishListEntity.getCategory4());
        return dto;
    }

    public List<WishListDTO> findAll() {
        return wishListRepository.findAll()
        .stream().map(it-> entityToDto(it)).collect(Collectors.toList());
    }

    public void delete(int index) {
        wishListRepository.deleteById(index);
    }

    public void addVisit(int index) {
        var wishItem = wishListRepository.findById(index);
        if(wishItem.isPresent()) {
            var item = wishItem.get();
        //흠
        }
    }
}
