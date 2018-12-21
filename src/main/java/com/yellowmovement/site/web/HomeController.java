package com.yellowmovement.site.web;

import java.util.ArrayList;
import java.util.List;

import com.yellowmovement.site.Credential;
import com.yellowmovement.site.repositories.PostRepository;
import com.yellowmovement.site.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.yellowmovement.site.Post;
import com.yellowmovement.site.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController {

    private List<Post> posts = new ArrayList<>();
    private PostRepository postRepository;
    private UserRepository userRepository;

    public HomeController(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    @ModelAttribute("postsList")
    public List<Post> addPostsToModel() {
        postRepository.findAll().forEach(i -> posts.add(i));

        return posts;
    }

    @ModelAttribute("loggedInUser")
    public User addUserToModel(@SessionAttribute("login") Credential loggedIn) {
        log.info(loggedIn.toString());
        User user = userRepository.findByEmail(loggedIn.getLoginEmail()).get(0);
        log.info(user.toString());
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
