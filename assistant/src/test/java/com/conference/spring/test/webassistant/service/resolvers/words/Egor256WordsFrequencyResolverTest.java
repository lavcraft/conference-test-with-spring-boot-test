package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.webassistant.domain.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author tolkv
 * @version 29/03/2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WordsFrequencyResolverTestConfiguration.class)
public class Egor256WordsFrequencyResolverTest {
  @Autowired
  Yegor256WordsFrequencyResolver yegor256WordsFrequencyResolver;

  @Test
  public void name() throws Exception {
    yegor256WordsFrequencyResolver.setAnswers("i am object and object within me");
    int match = yegor256WordsFrequencyResolver.match(Question.builder()
        .body("object in me")
        .build());

    assertThat(match, equalTo(1));

  }

}