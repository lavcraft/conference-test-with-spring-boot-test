package com.conference.spring.test.domain;

import lombok.Data;

/**
 * @author tolkv
 * @version 23/02/2017
 */
@Data
public class Question {
  String id;
  String userId;
  String body;

  QuestionType questionType;
}
