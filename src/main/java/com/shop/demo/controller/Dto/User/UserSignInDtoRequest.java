package com.shop.demo.controller.Dto.User;

import lombok.Data;

@Data
public class UserSignInDtoRequest {

    private String email;
    private String password;

}
