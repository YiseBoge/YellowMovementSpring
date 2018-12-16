package com.yellowmovement.site;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    private String dateString;

    @PrePersist
    void postedDate() {
        SimpleDateFormat format = new SimpleDateFormat("h:mm a - EEE, MMM d");

        this.postedDate = new Date();
        this.dateString = format.format(this.postedDate);
    }
}

