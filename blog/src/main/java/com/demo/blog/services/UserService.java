package com.demo.blog.services;

import com.demo.blog.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUserName(String userName);
}
