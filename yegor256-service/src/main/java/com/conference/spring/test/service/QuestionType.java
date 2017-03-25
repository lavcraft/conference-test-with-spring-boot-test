package com.conference.spring.test.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@RequiredArgsConstructor
@Getter
public enum QuestionType {
  JAVA(false), GROOVY(true), OTHER(true);

  private final boolean cacheable;
}
