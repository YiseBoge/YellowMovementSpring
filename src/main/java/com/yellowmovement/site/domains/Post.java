package com.yellowmovement.site.domains;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long postId;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String category;

    @Column(columnDefinition="varchar(50) default NULL")
    private String image;

    private Date postedDate;

    @PrePersist
    void postedDate() {
        this.postedDate = new Date();
    }

    @ManyToMany(targetEntity = Comment.class)
    List<Comment> comments = new ArrayList<>() ;

    public String dateString(){
        SimpleDateFormat format = new SimpleDateFormat("h:mm a - EEE, MMM d");
        return format.format(this.postedDate);
    }
}

