package com.Spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.Spring.demo", "com.Spring.demo.emailService"})
public class SpringWebProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebProject1Application.class, args);
	}

}
