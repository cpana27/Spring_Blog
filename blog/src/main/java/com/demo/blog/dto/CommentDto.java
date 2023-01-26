package com.demo.blog.dto;

import com.demo.blog.entity.Post;
import com.demo.blog.entity.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import java.util.Date;

public class CommentDto {

    private long id;
    private String body;
    private Date creatinDate;
    private Post post;
    private User user;

    public CommentDto(long id, String body, Date creatinDate, Post post, User user) {
        this.id = id;
        this.body = body;
        this.creatinDate = creatinDate;
        this.post = post;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatinDate() {
        return creatinDate;
    }

    public void setCreatinDate(Date creatinDate) {
        this.creatinDate = creatinDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
