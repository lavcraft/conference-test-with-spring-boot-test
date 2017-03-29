package com.conference.spring.test.webassistant.delete;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@Configuration
public class Config2 {
  @Bean
  public String haha2() {
    System.out.println("config2 = |");
    return "haha2";
  }
}
