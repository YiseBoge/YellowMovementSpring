package com.yellowmovement.site.controllers;

import com.yellowmovement.site.security.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@ModelAttribute("loggedInUser")
	public User addUserToModel(@AuthenticationPrincipal User user){ return user;}

	@GetMapping
	public String showProfile() {
		return "ProfilePage";
	}
}
