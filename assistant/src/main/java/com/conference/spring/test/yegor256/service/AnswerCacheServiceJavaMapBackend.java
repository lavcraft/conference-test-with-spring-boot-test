package com.conference.spring.test.yegor256.service;

import com.conference.spring.test.webassistant.domain.*;
import com.conference.spring.test.webassistant.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author tolkv
 * @version 25/03/2017
 */
//TODO bake this service with H2 database
@Service
public class AnswerCacheServiceJavaMapBackend implements AnswerCacheService {
  @Override
  public Optional<Answer> find(Question question) {
    return Optional.empty();
  }
}
