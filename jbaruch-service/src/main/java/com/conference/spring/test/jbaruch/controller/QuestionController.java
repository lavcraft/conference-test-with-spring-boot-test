package com.conference.spring.test.jbaruch.controller;

import com.conference.spring.test.jbaruch.AnswerResponse;
import com.conference.spring.test.jbaruch.FastAndTruthService;
import com.conference.spring.test.jbaruch.QuestionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@RestController
@RequiredArgsConstructor
public class QuestionController {
  private final FastAndTruthService fastAndTruthService;

  @PostConstruct
  public void inti(){
    System.out.println("fastAndTruthService = " + fastAndTruthService);
  }
  @RequestMapping(path = "/question", method = POST)
  public AnswerResponse handleQuestion(@RequestBody QuestionRequest question) {
    return AnswerResponse.builder()
        .answer(fastAndTruthService.handleQuestion(question))
        .build();
  }
}
