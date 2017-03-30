package com.conference.spring.test.webassistant.service.resolvers;

import com.conference.spring.test.common.GarbageProperties;
import com.conference.spring.test.common.utils.WordsComposer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author tolkv
 * @version 30/03/2017
 */
@Configuration
//@ComponentScan({
//    "com.conference.spring.test.common"
//})
public class WordsCommonConfiguration {
  @PostConstruct
  public void init() {
    System.out.println("Init666:" + this.getClass().getCanonicalName());
  }

  @Bean
  WordsComposer wordsComposer(){
    return new WordsComposer(getGarbageProperties());
  }

  @Bean
  public GarbageProperties getGarbageProperties() {
    GarbageProperties garbageProperties = new GarbageProperties();
    return garbageProperties;
  }
}
