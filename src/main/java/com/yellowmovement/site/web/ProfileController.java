package com.yellowmovement.site.web;

import com.yellowmovement.site.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@ModelAttribute("user")
	public User addUserToModel(@SessionAttribute("user") User loggedInUser){ return loggedInUser;}

	@GetMapping
	public String showProfile() {
		return "Profile";
	}
}
