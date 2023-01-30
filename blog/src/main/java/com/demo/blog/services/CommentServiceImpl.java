package com.demo.blog.services;

import com.demo.blog.entity.Comment;
import com.demo.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    private CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<Comment> getById(long id) {
        return commentRepository.findById(id);
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
