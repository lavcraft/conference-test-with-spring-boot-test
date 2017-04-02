package com.conference.spring.test.webassistant.persistence;

import com.conference.spring.test.webassistant.domain.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author tolkv
 * @version 27/03/2017
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEntity {
  @Id
  @GeneratedValue(strategy = AUTO)
  private String id;
  private String text;
  private String userId;
  private QuestionType questionType;

  @OneToOne
  private AnswerEntity answer;

}
