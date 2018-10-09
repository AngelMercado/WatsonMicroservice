package com.chatbot.userservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.chatbot.userservice.model.Role;
import com.chatbot.userservice.model.User;
import com.chatbot.userservice.model.UserRole;
import com.chatbot.userservice.service.Impl.UserServiceImpl;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class UserServiceApplication implements CommandLineRunner{
	@Autowired
	private UserServiceImpl userService; 
	
	public static void main(String args []) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Adams");
		user1.setUsername("jadams");
		user1.setPassword("password");
		user1.setEmail("jadams@gmail.com");
		
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1);
}
	

}