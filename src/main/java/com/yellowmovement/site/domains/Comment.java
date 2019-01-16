package com.yellowmovement.site.domains;

import com.yellowmovement.site.security.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Slf4j
@Data
@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long commentId;

    @OneToOne
    private User commenter;

    @NotNull
    private String content;

}
