package com.demo.blog.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import java.util.Date;

@Entity
@Table(name="")
public class Comment {
    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column(name = "")
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "")
    private Date creatinDate;

    @ManyToOne
    @JoinColumn(name= "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;


    public String comments(long id){
        Comment comment;
        String resString = "id=" +this.comments(id);
        return resString;
    }

}
