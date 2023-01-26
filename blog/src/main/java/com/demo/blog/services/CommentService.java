package com.demo.blog.services;

import com.demo.blog.entity.Comment;

public interface CommentService {
    Comment save(Comment comment);
    String delete(Comment comment);
}
