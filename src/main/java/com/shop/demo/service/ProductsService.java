package com.shop.demo.service;

import com.shop.demo.controller.Dto.NewProductRequestDto;
import com.shop.demo.model.Products;
import com.shop.demo.repositoey.ProductsRepository;
import com.shop.demo.service.Dto.ProductDto;

import com.shop.demo.util.ProductDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



@Slf4j
@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductDtoMapper mapper;


    public ProductDto creat(NewProductRequestDto request) {

        Products products=mapper.products(request);
        Products savedProduct=productsRepository.save(products);

        return mapper.productDto(savedProduct);
    }


}
