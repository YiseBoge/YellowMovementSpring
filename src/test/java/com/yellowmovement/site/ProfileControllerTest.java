package com.yellowmovement.site;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.yellowmovement.site.controllers.ProfileController;
import com.yellowmovement.site.repositories.PostRepository;
import com.yellowmovement.site.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testShowProfile() throws Exception{
		mockMvc.perform(get("/profile"))
			.andExpect(status().isOk())
			.andExpect(view().name("ProfilePage"));
	}
	@MockBean
	private UserService userservice;

}
