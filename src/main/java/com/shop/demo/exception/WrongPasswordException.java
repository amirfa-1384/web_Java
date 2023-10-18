package com.shop.demo.exception;

import org.springframework.http.HttpStatus;

public class WrongPasswordException extends SocialException{

    public WrongPasswordException() {
        super(HttpStatus.BAD_REQUEST,105);
    }
}
