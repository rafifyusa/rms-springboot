package com.mitrais.rmsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class RmsSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmsSpringbootApplication.class, args);
	}

}
