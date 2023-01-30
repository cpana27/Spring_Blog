package com.demo.blog.controller;

import com.demo.blog.entity.Post;
import com.demo.blog.entity.UserName;
import com.demo.blog.errorhandling.ResourceNotFoundException;
import com.demo.blog.services.PostService;
import com.demo.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PostController {

    private PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/posts")
    public Collection<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{postId}")
    public Post getPost(Long postId) throws ResourceNotFoundException {
        return postService.getById(postId).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) throws ResourceNotFoundException {
        return userService.findById(post.getId()).map(user -> {
            post.setUser((UserName) user);
            return postService.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + post.getId() + " not found"));
    }

    @PutMapping("/posts/{postId}")
    public Post updatePost(long id) throws ResourceNotFoundException {
        return postService.getById(id).map(post -> {
            post.setTitle(post.getTitle());
            post.setBody(post.getBody());
            return postService.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + id + " not found"));
    }
}
