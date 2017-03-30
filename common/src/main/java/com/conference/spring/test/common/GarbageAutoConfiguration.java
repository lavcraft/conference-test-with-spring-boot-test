package com.conference.spring.test.common;

import com.conference.spring.test.common.utils.AnswerComposer;
import com.conference.spring.test.common.utils.WordsComposer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author tolkv
 * @version 29/03/2017
 */
@Configuration
//@EnableConfigurationProperties(GarbageProperties.class)
public class GarbageAutoConfiguration {

  @Bean
  WordsComposer wordsComposer(GarbageProperties garbageProperties){
    return new WordsComposer(garbageProperties);
  }

  @Bean
  AnswerComposer answerComposer(GarbageProperties garbageProperties){
    return new AnswerComposer(wordsComposer(garbageProperties));
  }

}
