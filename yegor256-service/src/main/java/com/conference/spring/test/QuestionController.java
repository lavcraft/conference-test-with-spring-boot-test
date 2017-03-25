package com.conference.spring.test;

import com.conference.spring.test.service.Question;
import com.conference.spring.test.service.SlowRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@RestController
@RequiredArgsConstructor
public class QuestionController {
  private final SlowRecommendationService slowRecommendationService;

  @RequestMapping(path = "/question", method = RequestMethod.POST)
  public ResponseEntity handleQuestion(Question question) {
    slowRecommendationService.addQuestion(question);
    return ResponseEntity.ok().build();
  }
}
