package com.conference.spring.test.webassistant.service.jpa.assistant;

import com.conference.spring.test.webassistant.AssistantProperties;
import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.service.DefaultAssistantJpaBackend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertTrue;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DefaultAssistantConfiguration.class)
@DataJpaTest
public class DefaultAssistantJpaBackendTest {

  @Autowired
  DefaultAssistantJpaBackend defaultAssistantJpaBackend;

  @Autowired
  AssistantProperties assistantProperties;

  @Test
  public void should_load_default_answers() throws Exception {

    assertThat(defaultAssistantJpaBackend, notNullValue());

    Answer answer = defaultAssistantJpaBackend.handleQuestion(new Question());
    String answerText = answer.getAnswer();

    assertTrue(assistantProperties.getAnswers().contains(answerText));
  }
}
