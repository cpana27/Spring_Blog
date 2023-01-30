package com.demo.blog.repository;

import com.demo.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAll();
    Collection<Post> getAllByCreationDateAfter(Date date);
    Post findPostById(long id);
    Post findPostByTitle(String title);
    Post getPostByBodyContaining(String contain);
    Optional<Post> findById(Long aLong);
}
