package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@ControllerAdvice
public class BlogAPIExceptionHandler {

    // handle all bad requests
    @ExceptionHandler(value = {BlogAPIException.class})
    public ResponseEntity<Object> handleApiRequestException(BlogAPIException e){
        // 1.create payload containing exception details
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2.return response entity
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    // handle all not found
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e){
        // 1. create payload containing exception details
        ApiException apiException = new ApiException(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                ZonedDateTime.now()
        );

        // 2. return response entity
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiException);
    }
}
