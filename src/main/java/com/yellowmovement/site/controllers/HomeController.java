package com.yellowmovement.site.controllers;

import java.util.ArrayList;
import java.util.List;

import com.yellowmovement.site.repositories.PostRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.yellowmovement.site.domains.Post;
import com.yellowmovement.site.security.User;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController {

    private PostRepository postRepository;

    public HomeController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @ModelAttribute("categoriesList")
    public List<String> addCategoriesToModel() {
        List<String> categories = new ArrayList<>();

        postRepository.findCategoriesList().forEach(i -> categories.add(i));

        return categories;
    }

    @ModelAttribute("postsList")
    public List<Post> addPostsToModel() {
        List<Post> posts = new ArrayList<>();
        postRepository.findOrderedPosts().forEach(i -> posts.add(i));

        return posts;
    }

    @ModelAttribute("loggedInUser")
    public User addUserToModel(@AuthenticationPrincipal User user) {
        return user;
    }

    @GetMapping
    public String home() {
        return "HomePage";
    }


    @PostMapping
    public String homeProcessor() {
        return "HomePage";
    }


}
