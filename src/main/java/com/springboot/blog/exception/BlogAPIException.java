package com.springboot.blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BlogAPIException extends RuntimeException{

    private final HttpStatus httpStatus;

    public BlogAPIException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
