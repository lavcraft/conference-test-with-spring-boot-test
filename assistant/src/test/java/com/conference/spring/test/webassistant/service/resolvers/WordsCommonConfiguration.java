package com.conference.spring.test.webassistant.service.resolvers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author tolkv
 * @version 30/03/2017
 */
//@TestConfiguration
//@ComponentScan({
//    "com.conference.spring.test.common"
//})
@Configuration
@ComponentScan({
    "com.conference.spring.test.common"
})
public class WordsCommonConfiguration {
  @PostConstruct
  public void init() {
    System.out.println("Init666:" + this.getClass().getCanonicalName());
  }
}
