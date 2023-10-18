package com.shop.demo.service;


import com.shop.demo.controller.Dto.User.UserChangePasswordDto;
import com.shop.demo.controller.Dto.User.UserRegisterRequestDto;
import com.shop.demo.controller.Dto.User.UserSignInDtoRequest;
import com.shop.demo.exception.*;
import com.shop.demo.model.AuthenticationToken;
import com.shop.demo.model.User;
import com.shop.demo.repositoey.UserRepository;

import com.shop.demo.service.Dto.UserDto;
import com.shop.demo.service.Dto.UserSignInDto;
import com.shop.demo.util.DtoMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@Builder

public class UserService {

    private final UserRepository userRepository;
    private final DtoMapper mapper;
    private final AuthenticationService authenticationService;

    public UserDto register(UserRegisterRequestDto request){
        if (Objects.nonNull(userRepository.findByEmail(request.getEmail()))){
            throw new PresentException();
        }

        User savedUser=userRepository.save(mapper.user(request));

        final AuthenticationToken authenticationToken = new AuthenticationToken(savedUser);
        authenticationService.saveConfirmationToken(authenticationToken);

        return mapper.userDto(savedUser);
    }
//------------------------------------------------

    public UserSignInDto signIn(UserSignInDtoRequest request) {
        User user=userRepository.findByEmail(request.getEmail());
        if(Objects.isNull(user)){
            throw new NotFoundException();
        }

        if (!Objects.equals(user.getPassword(), request.getPassword())){
            throw new WrongPasswordException();
        }

        AuthenticationToken token=authenticationService.getToken(user);
        if(Objects.isNull(token)){
            throw new NotFoundTokenException();
        }
        return mapper.signInDto(request);
    }
//-----------------------------------------------

    public void changePass(UserChangePasswordDto request) {
        User user=userRepository.findByEmail(request.getEmail());
        if(Objects.isNull(user)) {
            throw new NotFoundException();
        }
        if (!Objects.equals(request.getLastPassword(), user.getPassword())){
            throw new WrongPasswordException();
        }

        user.setPassword(request.getNewPassword());
        userRepository.save(user);

    }


}
