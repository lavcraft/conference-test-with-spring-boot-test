package com.conference.spring.test;

import org.grpc.spring.boot.autoconfigure.annotation.EnableGRpcServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tolkv
 * @version 19/03/2017
 */

@SpringBootApplication
@EnableAutoConfiguration
@EnableGRpcServer
public class RecommendationApplication {
  public static void main(String[] args) {
    SpringApplication.run(RecommendationApplication.class, args);
  }
}
