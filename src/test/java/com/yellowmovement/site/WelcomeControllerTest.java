package com.yellowmovement.site;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import com.yellowmovement.site.controllers.WelcomeController;
import com.yellowmovement.site.security.User;
import com.yellowmovement.site.services.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
 
@WebMvcTest(WelcomeController.class)
public class WelcomeControllerTest {
	@MockBean
	private UserService userService;
	private MockMvc mockMvc;
	@Test
	public void homeTest() throws Exception {
		 mockMvc.perform(get("/"))
         .andExpect(status().isOk())
         .andExpect(view().name("index"));
	}
	@Test
	public void openCreateAccountPageTest() throws Exception {
		 mockMvc.perform(get("/createAccount"))
         .andExpect(status().isOk())
         .andExpect(view().name("redirect:/?performing=createAccount"));
	}
	@Test
	public void LogInTest() throws Exception {
		 mockMvc.perform(get("/login"))
         .andExpect(status().isOk())
         .andExpect(view().name("redirect:/?performing=login"));
	}
	@Test
	public void accessdeniedTest() throws Exception {
		 mockMvc.perform(get("/access-denied"))
         .andExpect(status().isOk())
         .andExpect(view().name("access_denied"));
	}
	@Test
	public void userTest() {
		WelcomeController w = new WelcomeController();
		User user = new User();
		assertThat(w.user()).isEqualTo(user);
	}
	
//	@Test
//	public void createNewUserTest() {
//		User user = new User("one","a@mail.com",1,"00","male");
//		User user2 = new User("two","ab@mail.com",1,"00","male");
//		Mockito.when(userService.findUserByEmail(user.getEmail())).thenReturn(user);
//		 
//		WelcomeController w = new WelcomeController();
//		w.createNewUser(user2, null ,null);
//		assertThat(userService.findUserByEmail(user.getEmail())).isNotEqualTo(user2);
//	}
}
