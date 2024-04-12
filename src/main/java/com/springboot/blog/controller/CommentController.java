package com.springboot.blog.controller;


import com.springboot.blog.dto.CommentDto;
import com.springboot.blog.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value="postId") long id,
                                                    @Valid @RequestBody CommentDto commentDto){

        return new ResponseEntity<>(commentService.createComment(id, commentDto), HttpStatus.CREATED);
    }


    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable(value="postId")Long postId){
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }


    @GetMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(name= "postId")Long postId,
                                                     @PathVariable(name = "id") Long commentId){
        CommentDto commentDto = commentService.getCommentById(postId, commentId);
        return ResponseEntity.ok(commentDto);
    }


    @PutMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(name= "postId") Long postId,
                                                    @PathVariable(name= "id") Long commentId,
                                                    @Valid @RequestBody CommentDto commentDto){
        CommentDto commentDtoResponse = commentService.updateComment(postId,commentId,commentDto);
        return ResponseEntity.ok(commentDtoResponse);
    }


    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(name="postId") Long postId,
                              @PathVariable(name = "id") Long id){
        commentService.deleteComment(postId, id);
        return ResponseEntity.ok("comment delete successfully");
    }
}
