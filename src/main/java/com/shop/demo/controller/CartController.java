package com.shop.demo.controller;


import com.shop.demo.controller.Dto.Cart.AddToCartRepositoryDto;
import com.shop.demo.controller.Dto.Cart.CartProductsDto;
import com.shop.demo.controller.Dto.Cart.CreatCartRepositoryRequestDto;
import com.shop.demo.controller.Dto.Cart.DeleteCartRepositoryDto;
import com.shop.demo.model.Products;
import com.shop.demo.repositoey.CartRepository;
import com.shop.demo.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartRepository cartRepository;

    @PostMapping("/new")
    public ResponseEntity<Void> newCart(@RequestBody CreatCartRepositoryRequestDto request){
        cartService.creat(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @PutMapping("/add")
    public ResponseEntity<Void> addToCart(@RequestBody AddToCartRepositoryDto request){
        cartService.add(request);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCart(@RequestBody DeleteCartRepositoryDto delete){
        cartService.remove(delete);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @GetMapping("/all")
    public Set<Products> getAllNotes(@RequestBody CartProductsDto request)
    {
        return cartService.getAll(request.getUserID());
    }

}
