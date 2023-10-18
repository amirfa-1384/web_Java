package com.shop.demo.controller.Dto.User;

import lombok.Data;

@Data
public class UserChangePasswordDto {

    private String email;
    private String lastPassword;
    private String newPassword;
}
