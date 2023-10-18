package com.shop.demo.controller.Dto.User;


import lombok.Data;


@Data
public class UserRegisterRequestDto {


    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private int idGame;

    private String password;
}
