package com.conference.spring.test.controller;

import com.conference.spring.test.domain.Answer;
import com.conference.spring.test.domain.Question;
import com.conference.spring.test.service.AssistantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@Slf4j
@RestController
public class QuestionController {
  private final AssistantService assistantService;

  public QuestionController(@Qualifier("composite.assistant") AssistantService assistantService) {
    this.assistantService = assistantService;
  }

  @RequestMapping(path = "/question", method = POST)
  public ResponseEntity handleQuestion(@RequestBody Question question) {
    Answer answer = assistantService.handleQuestion(question);
    if (answer != null) {
      log.info("{} answer: {}", answer.getOperatorId(), answer);
    } else {
      log.info("waiting yegor256 answer...");
    }
    return ResponseEntity.ok().build();
  }
}
