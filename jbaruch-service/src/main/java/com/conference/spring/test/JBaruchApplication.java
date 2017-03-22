package com.conference.spring.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@Slf4j
@SpringBootApplication
public class JBaruchApplication {
  @PostConstruct
  public void init(){
    log.info("BLABLA");
  }
  public static void main(String[] args) {
    SpringApplication.run(Config.class, args);
  }
}
