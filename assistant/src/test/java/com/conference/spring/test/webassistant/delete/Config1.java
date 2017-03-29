package com.conference.spring.test.webassistant.delete;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@Configuration
public class Config1 {
  @Bean public String haha(){
    System.out.println("config1 = |");
    return "haha";
  }
}
