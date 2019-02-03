package com.yellowmovement.site.controllers;

import com.yellowmovement.site.security.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@ModelAttribute("loggedInUser")
	public User addUserToModel(@AuthenticationPrincipal User user, Model model){
		model.addAttribute("title", user.getName());
		return user;
	}

	@GetMapping
	public String showProfile() {
		return "ProfilePage";
	}

	@GetMapping("/uploadImg")
	public String showProfileWithUploadmage() {
		return "redirect:/profile?performing=uploadImg";
	}

	@GetMapping("/edit")
	public String showProfileWithEdit() {
		return "redirect:/profile?performing=edit";
	}

	@PostMapping("/uploadImg")
	public String uploadImg() {

		// perform uploading tasks here
		return "redirect:/profile?performing=edit";
	}
}
