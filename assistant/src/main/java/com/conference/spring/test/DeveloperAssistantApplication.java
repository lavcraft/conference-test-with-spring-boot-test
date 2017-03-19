package com.conference.spring.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DeveloperAssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeveloperAssistantApplication.class, args);
	}
}
