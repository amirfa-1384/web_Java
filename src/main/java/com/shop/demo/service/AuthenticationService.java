package com.shop.demo.service;

import com.shop.demo.model.AuthenticationToken;
import com.shop.demo.model.User;
import com.shop.demo.repositoey.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final TokenRepository tokenRepository;


    public void saveConfirmationToken(AuthenticationToken authenticationToken){
        tokenRepository.save(authenticationToken);
    }


    public AuthenticationToken getToken(User user) {
        return tokenRepository.findByUser(user);
    }
}
