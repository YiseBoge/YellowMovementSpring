package com.yellowmovement.site.domains;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Entity
@AllArgsConstructor
@Table(name="posts")
public class Post {

	public Post() {}
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

    private String dateString;

    @PrePersist
    void postedDate() {
        SimpleDateFormat format = new SimpleDateFormat("h:mm a - EEE, MMM d");

        this.postedDate = new Date();
        this.dateString = format.format(this.postedDate);
    }

    @ManyToMany(targetEntity = Comment.class)
    List<Comment> comments = new ArrayList<>() ;
}

