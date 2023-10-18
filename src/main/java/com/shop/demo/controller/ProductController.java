package com.shop.demo.controller;


import com.shop.demo.controller.Dto.NewProductRequestDto;
import com.shop.demo.model.Products;
import com.shop.demo.repositoey.ProductsRepository;
import com.shop.demo.service.Dto.ProductDto;
import com.shop.demo.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductsService productsService;
    private final ProductsRepository productsRepository;

    @PostMapping("/new")
    public ProductDto creat(@RequestBody NewProductRequestDto request){
        return productsService.creat(request);

    }
    @GetMapping("/all")
    public List<Products> getAllNotes()
    {
        return productsRepository.findAll();
    }



}
