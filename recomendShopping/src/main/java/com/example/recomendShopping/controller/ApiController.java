package com.example.recomendShopping.controller;

import java.util.List;

import com.example.recomendShopping.service.WishListService;
import com.example.recomendShopping.wishlist.dto.WishListDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/recomend/shopping")
@RequiredArgsConstructor
public class ApiController {
    
    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDTO search(@RequestParam String query) {
        return wishListService.search(query);
    }

    @PostMapping()
    public WishListDTO add(@RequestBody WishListDTO wishListDTO) {
        log.info("{}", wishListDTO);
        return wishListService.add(wishListDTO);
    }

    @GetMapping("/all")
    public List<WishListDTO> findAll() {
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index) {
        wishListService.delete(index);
    }


}
