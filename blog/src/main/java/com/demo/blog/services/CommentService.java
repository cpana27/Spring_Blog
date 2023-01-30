package com.demo.blog.services;

import com.demo.blog.entity.Comment;

import java.util.Optional;

public interface CommentService {
    public Optional<Comment> getById(long id);

    Comment save(Comment comment);

    String delete(Comment comment);
}
