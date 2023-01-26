package com.demo.blog.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    @OneToMany(mappedBy = "user")
    @Transient
    private Collection<Post> postsCollection;

    public User(long id, Post posts, String userName, Collection<Post> postsCollection) {
        this.id = id;
        this.userName = userName;
        this.postsCollection = postsCollection;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPosts() {
        return (Post) this.postsCollection;
    }

    public void setPostsCollection(Collection<Post> postsCollection) {
        this.postsCollection = postsCollection;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
