package com.shop.demo.exception;

import org.springframework.http.HttpStatus;

public class PresentException extends SocialException{

    public PresentException() {
        super(HttpStatus.BAD_REQUEST,106);
    }
}
