package com.mentorship.userservice;

import com.mentorship.userservice.entities.Role;
import com.mentorship.userservice.entities.User;
import com.mentorship.userservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			populateUsers(userService);
		};
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void populateUsers(UserService userService) {
		userService.saveRole(new Role(null, "ROLE_USER"));
		userService.saveRole(new Role(null, "ROLE_ADMIN"));

		userService.saveUser(new User(null, "Jorix Sot", "jorix", "1234", new ArrayList<>()));
		userService.saveUser(new User(null, "Jorix Admin", "jorixa", "1234", new ArrayList<>()));

		userService.addRoleToUser("jorix", "ROLE_USER");
		userService.addRoleToUser("jorixa", "ROLE_ADMIN");
	}
}
