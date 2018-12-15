package com.yellowmovement.site.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
	
	@GetMapping
	public String profile() {
		return "Profile";
	}

}
