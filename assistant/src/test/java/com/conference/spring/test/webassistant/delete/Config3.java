package com.conference.spring.test.webassistant.delete;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@Configuration
public class Config3 {
  @Bean
  public String haha3(@Qualifier("haha") String haha) {
    System.out.println("config3 = |");
    System.out.println("hahabean = " + haha);
    return "haha3";
  }
}
