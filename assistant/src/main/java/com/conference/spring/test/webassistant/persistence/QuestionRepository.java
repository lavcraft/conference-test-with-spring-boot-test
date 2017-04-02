package com.conference.spring.test.webassistant.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author tolkv
 * @version 27/03/2017
 */
public interface QuestionRepository extends CrudRepository<QuestionEntity, String> {
  QuestionEntity findFirstByText(String text);

  @Modifying
  @Query("update QuestionEntity q set q.answer = ?1 where q.id = ?2")
  void setAnswerFor(AnswerEntity answer, String id);
}
