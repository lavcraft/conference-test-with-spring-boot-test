package com.conference.spring.test.webassistant.service.jpa.assistant;

import com.conference.spring.test.webassistant.AssistantProperties;
import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.service.DefaultAssistantJpaBackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertTrue;

/**
 * @author tolkv
 * @version 28/03/2017
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DefaultAssistantConfiguration.class)
//@ContextConfiguration(classes = DefaultAssistantConfiguration.class)
//@DataJpaTest
public class DefaultAssistantJpaBackendTest {

  @Value("${conference.yegor256.url}")
  String port;

  @Autowired
  DefaultAssistantJpaBackend defaultAssistantJpaBackend;

  @Autowired
  AssistantProperties assistantProperties;

//  @Test
  public void should_load_default_answers() throws Exception {

    assertThat(defaultAssistantJpaBackend, notNullValue());

    Answer answer = defaultAssistantJpaBackend.handleQuestion(Question.builder().build());
    String answerText = answer.getAnswer();

    assertTrue(assistantProperties.getAnswers().contains(answerText));
  }
}
