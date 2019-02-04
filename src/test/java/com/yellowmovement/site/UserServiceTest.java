package com.yellowmovement.site;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.yellowmovement.site.repositories.RoleRepository;
import com.yellowmovement.site.repositories.UserRepository;
import com.yellowmovement.site.security.Role;
import com.yellowmovement.site.security.User;
import com.yellowmovement.site.services.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@MockBean
	private UserRepository userRepository;
	@Autowired
	private UserServiceImpl userserviceimpl;
		
	@Test
	public void findUserByEmail() {
		String email = "a@gmail.com";
		final User u = new User();
		u.setEmail(email);
		Mockito.when(userRepository.findByEmail(email)).thenReturn(u);
		
		final User user = userserviceimpl.findUserByEmail(email);
		 
		assertThat(user.getEmail()).isEqualTo(u.getEmail());
	}
	
	@MockBean
	private RoleRepository rolereposity;
	
	@Test
	public void saveUser() {
		 final User u = new User("one","a@gmal.com",1,"0000","male");
		 Mockito.when(rolereposity.findByRole("USER")).thenReturn(new Role((long) 1,"USER"));
		 Mockito.when(userRepository.findByEmail(u.getEmail())).thenReturn(u);
		 Mockito.when(userRepository.save(u)).thenReturn(u);
		 assertThat(userserviceimpl.findUserByEmail(u.getEmail())).isEqualTo(u);
	}
	
	@Test
	public void loadUserByusername() {
		final User u = new User("one","a@gmal.com",1,"0000","male");
		Mockito.when(userRepository.findByEmail(u.getEmail())).thenReturn(u);
		
		assertNotNull(userserviceimpl.loadUserByUsername(u.getEmail()));
	}
}
