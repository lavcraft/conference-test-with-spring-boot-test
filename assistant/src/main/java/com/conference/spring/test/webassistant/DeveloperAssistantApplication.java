package com.conference.spring.test.webassistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
public class DeveloperAssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(DeveloperAssistantApplication.class, args);
	}
}
