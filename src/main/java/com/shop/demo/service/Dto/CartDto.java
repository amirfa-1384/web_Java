package com.shop.demo.service.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartDto {

    private Long user;
    private Long cartId;
}
