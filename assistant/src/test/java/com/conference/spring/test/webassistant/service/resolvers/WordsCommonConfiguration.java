package com.conference.spring.test.webassistant.service.resolvers;

import com.conference.spring.test.common.GarbageProperties;
import com.conference.spring.test.common.utils.WordsComposer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

/**
 * @author tolkv
 * @version 30/03/2017
 */
@TestConfiguration
@ComponentScan({
    "com.conference.spring.test.common"
})
public class WordsCommonConfiguration {
  @PostConstruct
  public void init() {
    System.out.println("Init666:" + this.getClass().getCanonicalName());
  }

  @Bean
  WordsComposer wordsComposer(GarbageProperties garbageProperties){
    return new WordsComposer(garbageProperties);
  }
}
