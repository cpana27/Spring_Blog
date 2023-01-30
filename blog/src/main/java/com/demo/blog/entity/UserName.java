package com.demo.blog.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "username")
public class UserName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String userName;
    @OneToMany(mappedBy = "user")
    @Transient
    @Column
    private Collection<Post> postsCollection;

    public UserName(long id, Post posts, String userName, Collection<Post> postsCollection) {
        this.id = id;
        this.userName = userName;
        this.postsCollection = postsCollection;
    }

    public UserName() {

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
