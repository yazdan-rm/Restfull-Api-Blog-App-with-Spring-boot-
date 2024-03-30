package com.springboot.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter

public class ApiException {
    private final String message;
    private final Integer httpStatus;
    private final ZonedDateTime timestamp;
}
