package com.shop.demo.controller;


import com.shop.demo.controller.Dto.User.UserChangePasswordDto;
import com.shop.demo.controller.Dto.User.UserRegisterRequestDto;
import com.shop.demo.controller.Dto.User.UserSignInDtoRequest;
import com.shop.demo.service.Dto.UserDto;
import com.shop.demo.service.Dto.UserSignInDto;
import com.shop.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping ("/register")
    public ResponseEntity<UserDto> signup(@RequestBody UserRegisterRequestDto request){
        return ResponseEntity.ok(userService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<UserSignInDto> signIn(@RequestBody UserSignInDtoRequest request){
        return ResponseEntity.ok(userService.signIn(request));
    }

    @PutMapping("/change pass")
    public ResponseEntity<Void> changePass(@RequestBody UserChangePasswordDto userChangePasswordDto){
        userService.changePass(userChangePasswordDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }



}
