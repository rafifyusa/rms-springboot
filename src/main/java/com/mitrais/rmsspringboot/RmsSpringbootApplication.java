package com.mitrais.rmsspringboot;

import com.mitrais.rmsspringboot.model.User;
import com.mitrais.rmsspringboot.service.Implementation.UserServiceImpl;
import com.mitrais.rmsspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class RmsSpringbootApplication implements CommandLineRunner {
	private UserServiceImpl userService;

	@Autowired
	public RmsSpringbootApplication(UserServiceImpl userService) {
		this.userService = userService;
	}


	public static void main(String[] args) {
		SpringApplication.run(RmsSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		{
			User newAdmin = new User("admin@mail.com", "Admin", "admin");
			userService.insertAdmin(newAdmin);
		}
	}

}
