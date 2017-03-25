package com.conference.spring.test.controller;

import com.conference.spring.test.client.Yegor256Client;
import com.conference.spring.test.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@RestController
@RequiredArgsConstructor
public class QuestionController {
  private final Yegor256Client yegor256Client;

  @RequestMapping(path = "/question", method = POST)
  public ResponseEntity handleQuestion(@RequestBody Question question) {
    yegor256Client.handleQuestion(question);
    return ResponseEntity.ok().build();
  }
}
