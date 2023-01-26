package com.demo.blog.dto;

import com.demo.blog.entity.Post;
import jakarta.persistence.*;

import java.util.Collection;

public class UserDto {

    private long id;
    private String userName;

    private Collection<Post> postsCollection;

    public UserDto(long id, String userName, Collection<Post> postsCollection) {
        this.id = id;
        this.userName = userName;
        this.postsCollection = postsCollection;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Post> getPostsCollection() {
        return postsCollection;
    }

    public void setPostsCollection(Collection<Post> postsCollection) {
        this.postsCollection = postsCollection;
    }
}
