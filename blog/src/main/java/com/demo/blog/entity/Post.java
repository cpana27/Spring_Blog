package com.demo.blog.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="post")
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
}
