package com.demo.blog.services;

import com.demo.blog.entity.UserName;
import com.demo.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserName> findByUserName(String userName) {
        return Optional.ofNullable(userRepository.getUserByUserName(userName));
    }

    @Override
    public Optional<Object> findById(long userId) {
        return Optional.ofNullable(userRepository.findById(userId));
    }

    @Override
    public UserName save(UserName user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserName> getAll() {
        return null;
    }

}
