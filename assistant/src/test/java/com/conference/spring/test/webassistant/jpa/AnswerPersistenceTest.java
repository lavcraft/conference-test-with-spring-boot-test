package com.conference.spring.test.webassistant.jpa;

import com.conference.spring.test.webassistant.persistence.AnswerEntity;
import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import com.conference.spring.test.webassistant.persistence.QuestionEntity;
import com.conference.spring.test.webassistant.persistence.QuestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author tolkv
 * @version 27/03/2017
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AnswerPersistenceTest {
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private AnswersRepository answersRepository;

  @Autowired
  private QuestionRepository questionRepository;

  @Test
  public void should_persist_and_read() throws Exception {
    QuestionEntity questionEntity = QuestionEntity.builder()
        .text("question?")
        .build();
    questionEntity = entityManager.persist(questionEntity);
    AnswerEntity persist = entityManager.persist(AnswerEntity.builder()
        .text("answer")
        .build());

    assertNotNull(answersRepository.findOne(persist.getId()));
    assertNotNull(questionRepository.findOne(questionEntity.getId()));
  }
}
