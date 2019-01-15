package com.yellowmovement.site.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.yellowmovement.site.repositories.PostRepository;
import com.yellowmovement.site.repositories.UserRepository;
import com.yellowmovement.site.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.yellowmovement.site.domains.Credential;
import com.yellowmovement.site.security.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    private UserService userService;

    @ModelAttribute(name="user")
    public User user() {
        return new User();
    }

    @GetMapping("/login")
    public String login(){
        return "redirect:/?performing=login";
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

    @GetMapping("/createAccount")
    public String openCreateAccountPage(){
        return "redirect:/performing=createAccount";
    }

    @PostMapping("/createAccount")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("username", "error.username",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            return "redirect:/?performing=createAccount";
        } else {

            userService.saveUser(user);

            model.addAttribute("successMessage", "User has been registered successfully");

            return "redirect:/";
        }
    }

}
