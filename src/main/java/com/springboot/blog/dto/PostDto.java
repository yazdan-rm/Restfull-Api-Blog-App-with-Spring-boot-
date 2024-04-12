package com.springboot.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private long id;
    // title should not be null or empty
    // title should have at least 2 character
    @NotEmpty(message = "title should not be null or empty")
    @Size(min = 2, message = "Post title should have at least 2 character")
    private String title;

    // description should not be null or empty
    // description should have at least 10 character
    @NotEmpty(message = "description should not be null or empty")
    @Size(min = 10, message = "description title should have at least 10 character")
    private String description;

    // content should not be null or empty
    @NotEmpty(message = "content should not be null or empty")
    private String content;

    private Set<CommentDto> comments;
}
