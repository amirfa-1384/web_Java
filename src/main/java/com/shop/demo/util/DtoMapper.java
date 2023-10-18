package com.shop.demo.util;


import com.shop.demo.controller.Dto.User.UserRegisterRequestDto;
import com.shop.demo.controller.Dto.User.UserSignInDtoRequest;
import com.shop.demo.model.User;
import com.shop.demo.service.Dto.UserDto;
import com.shop.demo.service.Dto.UserSignInDto;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    public User user(UserRegisterRequestDto request){
        User user=User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .idGame(request.getIdGame())
                .password(request.getPassword())
                .build();
        return user;

    }

    public UserDto userDto(User user){
        return  UserDto.builder()
                .Id(user.getId())
                .email(user.getEmail())
                .build();
    }

    public UserSignInDto signInDto(UserSignInDtoRequest request){
        return UserSignInDto.builder()
                .email(request.getEmail())
                .build();
    }
}
