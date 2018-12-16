package com.yellowmovement.site.web;

import java.util.ArrayList;
import java.util.List;

import com.yellowmovement.site.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yellowmovement.site.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController {

    List<Post> posts = new ArrayList<>();
    PostRepository postRepository;

    public HomeController(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    @ModelAttribute
    public void addPostsToModel(Model model) {
        postRepository.findAll().forEach(i -> posts.add(i));

        model.addAttribute("postsList", posts);
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
