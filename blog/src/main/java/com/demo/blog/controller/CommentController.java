package com.demo.blog.controller;

import com.demo.blog.entity.Comment;
import com.demo.blog.entity.Post;
import com.demo.blog.errorhandling.ResourceNotFoundException;
import com.demo.blog.services.CommentService;
import com.demo.blog.services.PostService;
import com.demo.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CommentController {

    private PostService postService;
    private CommentService commentService;
    private UserService userService;

    @Autowired
    public CommentController(PostService postService, CommentService commentService, UserService userService) {
        this.postService = postService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/posts/{postId}/comments")
    public Optional<Comment> getAllCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return commentService.getById(postId);
    }

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable(value = "postId") long postId,
                                 @RequestBody Comment comment) throws ResourceNotFoundException {
        return postService.getById(postId).map(post -> {
            comment.setPost(post);
            return commentService.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public Comment getCommentById(@PathVariable(value = "postId") long postId,
                                  @PathVariable(value = "commentId") Long commentId) throws ResourceNotFoundException {
        Post post = postService.getById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
        return commentService.getById(commentId).map(comment -> {
            if (comment.getPost().equals(post)) {
                return comment;
            } else {
                try {
                    throw new ResourceNotFoundException("CommentId " + commentId + " not found");
                } catch (ResourceNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + " not found"));
    }
}
