package com.demo.blog.repository;

import com.demo.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Collection<Post> getAll();
    Post findPostById(long id);
    Post findPostByTitle(long id);
    Post getPostByBodyContaining(String contain);
    Optional<Post> findById(Long aLong);
}
