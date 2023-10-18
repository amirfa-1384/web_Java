package com.shop.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public class SocialException extends RuntimeException {

    private final HttpStatus status;
    private final Integer code;
}
