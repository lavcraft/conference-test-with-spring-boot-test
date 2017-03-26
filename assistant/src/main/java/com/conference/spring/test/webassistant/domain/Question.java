package com.conference.spring.test.webassistant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tolkv
 * @version 23/02/2017
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
  private String id;
  private String userId;
  private String body;

  private QuestionType questionType;
}
