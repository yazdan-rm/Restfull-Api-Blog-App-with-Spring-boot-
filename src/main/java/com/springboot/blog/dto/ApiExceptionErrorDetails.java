package com.springboot.blog.dto;

import java.util.Date;


public record ApiExceptionErrorDetails(String message,
                                       Integer httpStatusCode,
                                       Date timestamp,
                                       String pathRequest) {
}
