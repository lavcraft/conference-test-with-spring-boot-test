package com.conference.spring.test.jbaruch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
  private String id;
  private String userId;
  private String body;

  private QuestionType questionType;
}
