package com.yellowmovement.site.web;

import java.util.ArrayList;
import java.util.List;

import com.yellowmovement.site.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.yellowmovement.site.Post;
import com.yellowmovement.site.User;

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
    public User addUserToModel(HttpSession session) {
        log.info(session.toString());
        if (session.getAttribute("loggedInUser")==null){
            return null;
        }
        User user = (User)session.getAttribute("loggedInUser");
        log.info(user.toString());
        return user;
    }

    @GetMapping
    public String home(HttpSession session) {

        if (session.getAttribute("loggedInUser")==null){
            return "redirect:/";
        }
        return "HomePage";
    }


    @PostMapping
    public String homeProcessor() {
        return "HomePage";
    }


}
