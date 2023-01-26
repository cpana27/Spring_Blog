package com.demo.blog.services;

import com.demo.blog.entity.Comment;
import com.demo.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    @Autowired
    private CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @Override
    public Comment save(Comment comment) {
        return (Comment) commentRepository.saveAndFlush(comment);
    }

    @Override
    public String delete(Comment comment) {
        commentRepository.delete(comment);
        return "Succesfull deleted";
    }
}
