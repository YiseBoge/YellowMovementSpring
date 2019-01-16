package com.yellowmovement.site;

import static org.junit.Assert.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yellowmovement.site.security.User;
import com.yellowmovement.site.services.UserService;
import com.yellowmovement.site.services.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YellowMovementSiteApplicationTests {
	
	@Autowired
	private UserServiceImpl userService;
	
	
	@Before(value = "")
	 public void initDB() {
		 {
			 User newUser = new User( "User 1","example1@example.com",1,"0000","female");
			 userService.saveUser(newUser);
		 }
		 
	 }
	 @Test
	 public void testUser() {
		 User user = userService.findUserByEmail("example1@example.com");
		 assertNotNull(user);
	 }

}
