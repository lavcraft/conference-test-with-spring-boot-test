package com.conference.spring.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author tolkv
 * @version 19/03/2017
 */

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class Yegor256Application {
  public static void main(String[] args) {
    SpringApplication.run(Yegor256Application.class, args);
  }
}
