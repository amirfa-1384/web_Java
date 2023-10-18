package com.shop.demo.exception;

import org.springframework.http.HttpStatus;

public class NoInventoryException extends SocialException{

    public NoInventoryException() {
        super(HttpStatus.BAD_REQUEST,107);
    }
}
