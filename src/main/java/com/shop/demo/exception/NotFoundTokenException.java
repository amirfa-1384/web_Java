package com.shop.demo.exception;

import org.springframework.http.HttpStatus;

public class NotFoundTokenException extends SocialException{
    public NotFoundTokenException() {
        super(HttpStatus.NOT_FOUND,103);
    }
}
