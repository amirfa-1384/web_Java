package com.shop.demo.service.Dto;

import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class ProductDto {

    private Long Id;
    private String productName;
    private Long price;
    private Long inventory;
}
