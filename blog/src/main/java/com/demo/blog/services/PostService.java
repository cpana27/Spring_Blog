package com.demo.blog.services;

import com.demo.blog.entity.Post;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public interface PostService {
    Optional<Post> getById(long id);
    Collection<Post> getAll(Date date);
    Post save(Post post);

    void delete(Post post);
}
