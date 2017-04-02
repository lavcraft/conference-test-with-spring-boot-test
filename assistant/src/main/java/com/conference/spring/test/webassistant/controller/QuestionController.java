package com.conference.spring.test.webassistant.controller;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.service.AnswerCacheService;
import com.conference.spring.test.webassistant.service.AssistantServiceJavaGuruBackend;
import com.conference.spring.test.webassistant.service.NotificationService;
import com.conference.spring.test.webassistant.service.resolvers.question.QuestionTypeResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class QuestionController {
  private final NotificationService notificationService;
  private final AssistantServiceJavaGuruBackend assistantService;
  private final QuestionTypeResolver questionTypeResolver;
  private final AnswerCacheService answerCacheService;

  @PostMapping("/question")
  public ResponseEntity handleQuestion(@RequestBody Question question) {
    question.setQuestionType(questionTypeResolver.resolveType(question));

    Answer answer = assistantService.handleQuestion(question);
    if (answer != null) {
      log.info("{} answer: {}", answer.getOperatorId(), answer);
      notificationService.notify(answer);
    } else {
      log.info("waiting yegor256 answer...");
    }
    return ResponseEntity.ok("{}");
  }
}
