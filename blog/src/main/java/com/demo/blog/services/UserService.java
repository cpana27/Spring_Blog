package com.demo.blog.services;

import com.demo.blog.entity.UserName;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserName> findByUserName(String userName);

    Optional<Object> findById(long userId);

    UserName save(UserName user);

    List<UserName> getAll();
}
