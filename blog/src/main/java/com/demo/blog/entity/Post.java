package com.demo.blog.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String title;
    @Column
    private String body;
    @Column
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserName user;


    //Default Constructor
    public Post() {
    }

    public Post(long id, String title, String body, Date creationDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserName getUser() {
        return user;
    }

    public void setUser(UserName user) {
        this.user = user;
    }
}
