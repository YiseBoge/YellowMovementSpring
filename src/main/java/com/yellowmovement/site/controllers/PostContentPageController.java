package com.yellowmovement.site.controllers;


import com.yellowmovement.site.domains.Comment;
import com.yellowmovement.site.domains.Post;
import com.yellowmovement.site.repositories.CommentRepisotory;
import com.yellowmovement.site.security.User;
import com.yellowmovement.site.repositories.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/post")
public class PostContentPageController {

    private PostRepository postRepository;
    private CommentRepisotory commentRepisotory;

    public PostContentPageController(PostRepository postRepository, CommentRepisotory commentRepisotory){
        this.postRepository = postRepository;
        this.commentRepisotory = commentRepisotory;
    }


    @ModelAttribute("loggedInUser")
    public User addUserToModel(@AuthenticationPrincipal User user) {
        return user;
    }

    @ModelAttribute("comment")
    public Comment addCommentToModel() {
        return new Comment();
    }


    @GetMapping("/{postId}")
    public String openPostPage(@PathVariable("postId") Long postId, Model model){
        Optional<Post> currentPost = postRepository.findById(postId);

        if (currentPost.isPresent()){
            model.addAttribute("currentPost", currentPost.get());

            model.addAttribute("title", currentPost.get().getTitle());
        }

        return "PostContentPage";
    }


    @PostMapping("/comment")
    public String openPostPage(@Valid @ModelAttribute("comment") Comment comment, Errors errors, @RequestParam("postId") Long postId, @AuthenticationPrincipal User user, Model model){
        Optional<Post> currentPost = postRepository.findById(postId);
        Post post = currentPost.get();;


        model.addAttribute("currentPost", post);

        if (errors.hasErrors()){
            log.info(comment.toString());
            log.info(post.toString());
            return "PostContentPage";
        }


        comment.setCommenter(user);

        commentRepisotory.save(comment);
        post.getComments().add(comment);

        postRepository.save(post);

        model.addAttribute("comment", new Comment());

        return "PostContentPage";
    }


}
