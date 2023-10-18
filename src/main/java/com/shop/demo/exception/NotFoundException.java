package com.shop.demo.exception;

import org.hibernate.WrongClassException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends SocialException{

    public NotFoundException() {
        super(HttpStatus.NOT_FOUND, 102);
    }




}
