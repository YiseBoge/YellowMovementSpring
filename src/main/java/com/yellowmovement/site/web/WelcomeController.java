package com.yellowmovement.site.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yellowmovement.site.User;

import jdk.internal.jline.internal.Log;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	private ArrayList<User> usersList = new ArrayList<User>();
	
  
  @GetMapping
  public String home() {
	  usersList.add(new User("example1@example.com", "0000"));
	  usersList.add(new User("example2@example.com", "0000"));
    return "index";    
  }
  
  @GetMapping("logout")
  public String logout() {
    return "index";    
  }

  @PostMapping("/login")
  public String loginRequestor(@ModelAttribute("loginForm") User opener, Errors errors, Model model) {
//	  if (errors.hasErrors()) {
//	      return "index";
//	    }
	  for (User user: usersList) {
		  if(user.getEmail() == opener.getEmail()) {
			  if(opener.getPassword() == user.getPassword()) {
				  
				// Save in the logged in users list
				  
				  return "redirect:/home";
			  }

		  }
		  return "index";
		  
	  }
	return "index";
	  
	  
  }
}
