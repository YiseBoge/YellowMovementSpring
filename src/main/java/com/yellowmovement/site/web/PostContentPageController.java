package com.yellowmovement.site.web;


import com.yellowmovement.site.Post;
import com.yellowmovement.site.User;
import com.yellowmovement.site.repositories.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/post")
public class PostContentPageController {

    private PostRepository postRepository;

    public PostContentPageController(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    @ModelAttribute("loggedInUser")
    public User addUserToModel(HttpSession session) {
        if (session.getAttribute("loggedInUser")==null){
            return null;
        }
        User user = (User)session.getAttribute("loggedInUser");
        log.info(user.toString());
        return user;
    }


    @GetMapping("/{postId}")
    public String openPostPage(@PathVariable("postId") Long postId, Model model, HttpSession session){
        if (session.getAttribute("loggedInUser")==null){
            return "redirect:/";
        }

        Optional<Post> currentPost = postRepository.findById(postId);

        if (currentPost.isPresent()){
            model.addAttribute("currentPost", currentPost.get());
        }

        return "PostContentPage";
    }
}
