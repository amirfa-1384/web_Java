package com.shop.demo.util;


import com.shop.demo.controller.Dto.NewProductRequestDto;
import com.shop.demo.model.Products;
import com.shop.demo.service.Dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    public Products products(NewProductRequestDto request){
        Products products=Products.builder()
                .productName(request.getProductName())
                .price(request.getPrice())
                .inventory(request.getInventory())
                .build();
        return products;

    }

    public ProductDto productDto(Products products){
        return  ProductDto.builder()
                .Id(products.getId())
                .productName(products.getProductName())
                .price(products.getPrice())
                .inventory(products.getInventory())
                .build();
    }
}
