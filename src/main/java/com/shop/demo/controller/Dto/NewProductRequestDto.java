package com.shop.demo.controller.Dto;

import lombok.Data;



@Data

public class NewProductRequestDto {


    private Long Id;
    private String productName;
    private Long price;
    private Long inventory;

}
