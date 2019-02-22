package com.yellowmovement.site;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.yellowmovement.site.controllers.ProfileController;

@RunWith(SpringRunner.class)
@WebMvcTest(ProfileController.class)
public class ProfileControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
//	@Test
//	public void testHomePage() throws Exception {
//		mockMvc.perform(get("/profile"))
//		.andExpect(status().isOk())
//		Expects HTTP 200
//		.andExpect(view().name("home"))
//		.andExpect(content().string(
//		containsString("Welcome to...")));
//	}
}
