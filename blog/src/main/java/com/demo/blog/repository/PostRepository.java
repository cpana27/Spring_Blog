package com.demo.blog.repository;

import com.demo.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostRepository extends JpaRepository<Post, Long> {
    Collection<Post> getAll();
    Post findPostById(long id);
    Post findPostByTitle(long id);
    Post getPostByBodyContaining(String contain);
}
