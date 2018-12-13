package com.yellowmovement.site;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

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
    void placedAt() {
        this.postedDate = new Date();
    }
}

