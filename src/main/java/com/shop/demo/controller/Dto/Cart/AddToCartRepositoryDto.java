package com.shop.demo.controller.Dto.Cart;

import lombok.Data;

@Data
public class AddToCartRepositoryDto {

    private Long cartId;
    private Long productId;
    private Long num;


}
