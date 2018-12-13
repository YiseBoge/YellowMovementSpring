package com.yellowmovement.site.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yellowmovement.site.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController {

    @ModelAttribute
    public void addPostsToModel(Model model) {
        List<Post> posts = Arrays.asList(
                new Post("p01", "Post 1", "Here goes the contents of the first post in the entry", "General", "January 3, 2018"),
                new Post("p02", "Post 2", "Then goes the second post with the blah and blah.", "Science and Technology", "June 24, 2000"),
                new Post("p03", "Post 3", "Ans here i declare post thy third with his grace and glory", "Feminist Clubs", "October 1, 1998"),
                new Post("p04", "Post 4", "Fourthly, we all die and nothing in life matters", "Entertainment", "February 13, 2017"));

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
