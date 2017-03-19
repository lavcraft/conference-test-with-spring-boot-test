package com.conference.spring.test.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tolkv
 * @version 23/02/2017
 */
@AllArgsConstructor
@Getter
public enum QuestionType {
  JAVA(false), GROOVY(true), OTHER(true);

  private final boolean cacheable;
}