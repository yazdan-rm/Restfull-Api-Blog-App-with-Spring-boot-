package com.springboot.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class CommentDto {
    private long id;

    // name should not be null or empty
    @NotEmpty(message ="name should not be null or empty")
    private String name;

    // email should not be null or empty
    @NotEmpty(message = "email should not be null or empty")
    // email field validation
    @Email(message = "Input for email field is not valid")
    private String email;

    // comment body should not be null or empty
    @NotEmpty(message = "comment body should not be null or empty ")
    // comment body must be minimum 10 characters
    @Size(min = 10, message = "comment body must be minimum 10 characters")
    private String body;
}
