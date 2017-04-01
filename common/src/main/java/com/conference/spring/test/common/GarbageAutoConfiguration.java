package com.conference.spring.test.common;

import com.conference.spring.test.common.utils.AnswerComposer;
import com.conference.spring.test.common.utils.WordsComposer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author tolkv
 * @version 29/03/2017
 */
@Configuration
//@EnableConfigurationProperties(GarbageProperties.class)
@PropertySource("classpath:user.properties")
public class GarbageAutoConfiguration {

  @Bean
  GarbageProperties garbageProperties(){
    return new GarbageProperties();
  }

  @Bean
  WordsComposer wordsComposer(GarbageProperties garbageProperties) {
    return new WordsComposer(garbageProperties);
  }

  @Bean
  AnswerComposer answerComposer(GarbageProperties garbageProperties) {
    return new AnswerComposer(wordsComposer(garbageProperties));
  }

}
