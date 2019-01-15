package com.yellowmovement.site.domains;

import com.yellowmovement.site.security.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Data
@Entity
@Table(name="blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long blogId;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @Column(columnDefinition="varchar(50) default NULL")
    private String image;

    private Date bloggedDate;

    private String dateString;

    @PrePersist
    void postedDate() {
        SimpleDateFormat format = new SimpleDateFormat("h:mm a - EEE, MMM d");

        this.bloggedDate = new Date();
        this.dateString = format.format(this.bloggedDate);
    }

    @ManyToOne
    private User blogger;

    @ManyToMany(targetEntity = Comment.class)
    List<Comment> comments = new ArrayList<>() ;
}
