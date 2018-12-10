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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yellowmovement.site.Credential;
import com.yellowmovement.site.Post;
import com.yellowmovement.site.User;

import jdk.internal.jline.internal.Log;

@Controller
@RequestMapping("/")
public class WelcomeController {
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		ArrayList<User> usersList = new ArrayList<User>();
		usersList.add(new User("User 1", "example1@example.com", "0000"));
		usersList.add(new User("User 2", "example2@example.com", "0000"));
		 
		model.addAttribute("usersList",usersList);
	}
	
  
  @GetMapping
  public String home(Model model) {
	  
	  return "index";    
  }
  
  @GetMapping("logout")
  public String logout() {
    return "index";    
  }

  @PostMapping("/login")
  public String loginRequestor(@Valid @ModelAttribute("loginForm") Credential requester, @ModelAttribute("usersList") ArrayList<User> usersList , Errors errors, Model model) {
	  if (errors.hasErrors()) {
	      return "index";
	    }
	  for (User user: usersList) {
		  if(requester.getLoginEmail().equals(user.getEmail())) {
			  if(requester.getLoginPassword().equals(user.getPassword())) {
				  
				model.addAttribute("loggedInUser", user);
				  
				return "redirect:/home";
			  }
			  return "index";
		  }
		  
	  }
	return "index";
	  
	  
  }
}
