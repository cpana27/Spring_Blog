package com.demo.blog.controller;

import com.demo.blog.entity.UserName;
import com.demo.blog.errorhandling.ResourceNotFoundException;
import com.demo.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserName> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{userId}")
    public UserName getUserById(@PathVariable(value = "userId") long userId) throws ResourceNotFoundException {
        return (UserName) userService.findById(userId).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    @PostMapping("/user")
    public UserName createUser(@RequestBody UserName user) {
        return userService.save(user);
    }

    @PutMapping("/users/{userId}")
    public UserName updateUser(@PathVariable(value = "userId") long userId,
                               @RequestBody UserName userDetails) throws ResourceNotFoundException {
        return userService.findById(userId).map(user -> {
            user.equals(userDetails.getUserName());
            return userService.save((UserName) user);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }


}
