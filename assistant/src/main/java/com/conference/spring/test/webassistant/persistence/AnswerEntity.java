package com.conference.spring.test.webassistant.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

/**
 * @author tolkv
 * @version 27/03/2017
 */
@Entity
@Data
@Builder
@AllArgsConstructor
public class AnswerEntity {
  @Id
  @GeneratedValue(strategy = AUTO)
  private String id;
  private String text;
  @OneToOne
  private QuestionEntity question;
}
