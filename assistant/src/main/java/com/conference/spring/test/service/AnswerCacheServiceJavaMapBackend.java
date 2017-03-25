package com.conference.spring.test.service;

import com.conference.spring.test.domain.*;
import com.conference.spring.test.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@Service
public class AnswerCacheServiceJavaMapBackend implements AnswerCacheService {
  @Override
  public Optional<Answer> find(Question question) {
    return Optional.empty();
  }
}
