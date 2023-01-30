package com.demo.blog.repository;

import com.demo.blog.entity.Comment;
import com.demo.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findCommentById(long id);

}
