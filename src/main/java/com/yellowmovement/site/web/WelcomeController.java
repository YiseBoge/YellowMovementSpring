package com.yellowmovement.site.web;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yellowmovement.site.Credential;
import com.yellowmovement.site.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class WelcomeController {

    ArrayList<User> usersList = new ArrayList<User>();

    public WelcomeController() {

        usersList.add(new User("User 1", "example1@example.com", "0000"));
        usersList.add(new User("User 2", "example2@example.com", "0000"));

    }

    @ModelAttribute("login")
    public Credential loginCreate() {
        return new Credential();
    }

    @GetMapping
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
    }


    @PostMapping("/login")
    public String loginRequestor(@Valid @ModelAttribute("login") Credential requester, Errors errors, Model model) {
        if (errors.hasErrors()) {
            log.info(errors.getAllErrors().toString());
            return "index";
        }
        for (User user : usersList) {
            if (requester.getLoginEmail().equals(user.getEmail())) {
                if (requester.getLoginPassword().equals(user.getPassword())) {

                    model.addAttribute("loggedInUser", user);

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
}
