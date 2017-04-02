package com.conference.spring.test.webassistant.service.resolvers.question;

import com.conference.spring.test.common.utils.WordsComposer;
import com.conference.spring.test.webassistant.service.resolvers.words.JBaruchWordsFrequencyResolver;
import com.conference.spring.test.webassistant.service.resolvers.words.WordsFrequencyResolver;
import com.conference.spring.test.webassistant.service.resolvers.words.Yegor256WordsFrequencyResolver;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author tolkv
 * @version 30/03/2017
 */
//@TestConfiguration
//@PropertySource("classpath:application-yegor_vs_jbaruch.yml")
@TestConfiguration
public class TextBasedQuestionTypeResolverTestConfiguration {

  @PostConstruct
  public void init() {
    System.out.println("init777:" + this.getClass().getCanonicalName());
  }

  @Bean
  Yegor256WordsFrequencyResolver yegor256WordsFrequencyResolver2(WordsComposer composer) {
    return new Yegor256WordsFrequencyResolver(composer);
  }

  @Bean
  JBaruchWordsFrequencyResolver jBaruchWordsFrequencyResolver(WordsComposer composer) {
    return new JBaruchWordsFrequencyResolver(composer);
  }

  @Bean
  TextBasedQuestionTypeResolver textBasedQuestionTypeResolver(List<WordsFrequencyResolver> resolverList) {
    return new TextBasedQuestionTypeResolver(resolverList);
  }
}
