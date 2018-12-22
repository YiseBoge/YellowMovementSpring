package com.yellowmovement.site.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.yellowmovement.site.repositories.PostRepository;
import com.yellowmovement.site.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.yellowmovement.site.Credential;
import com.yellowmovement.site.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/")
public class WelcomeController {

    List<User> usersList = new ArrayList<>();
    UserRepository userRepository;

    @Autowired
    public WelcomeController(UserRepository userRepository) {

        this.userRepository = userRepository;
        this.userRepository.findAll().forEach(i -> usersList.add(i));

    }

    @ModelAttribute("loggedInUser")
    public User getLoggedIn(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null){
            return null;
        }
        return (User)session.getAttribute("loggedInUser");
    }

    @ModelAttribute("login")
    public Credential loginCreate() {
        return new Credential();
    }

    @ModelAttribute("account")
    public User createAccount() {
        return new User();
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "redirect:/";
    }


    @PostMapping("/login")
    public String loginRequestor(@Valid @ModelAttribute("login") Credential requester, Errors errors, HttpSession session) {
        if (errors.hasErrors()) {
            log.info(errors.getAllErrors().toString());
            return "index";
        }
        for (User user : usersList) {
            if (requester.getLoginEmail().equals(user.getEmail())) {
                if (requester.getLoginPassword().equals(user.getPassword())) {

                    session.setAttribute("loggedInUser", user);

                    log.info("Found password too");
                    return "redirect:/home";
                }
                log.info("Found email");
                return "index";
            }

        }
        log.info("Found nothing");
        return "index";


    }

    @PostMapping("/createAccount")
    public String accountCreator(@Valid @ModelAttribute("account") User user, Errors errors, Model model, PostRepository postRepository) {
        if (errors.hasErrors()) {
            log.info(errors.getAllErrors().toString());
            return "index";
        }

        User savedUser = userRepository.save(user);
        log.warn(savedUser.toString());
        this.usersList.add(savedUser);
        return "index";


    }

}
