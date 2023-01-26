package com.demo.blog.services;

import com.demo.blog.entity.Post;
import com.demo.blog.repository.PostRepository;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> getById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Collection<Post> getAll(Date date) {
        return postRepository.getAllByCreationDateAfter(date);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
