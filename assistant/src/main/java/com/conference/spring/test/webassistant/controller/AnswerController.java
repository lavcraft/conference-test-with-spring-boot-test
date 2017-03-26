package com.conference.spring.test.webassistant.controller;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

import static com.conference.spring.test.common.utils.IconConstants.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author tolkv
 * @version 23/03/2017
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class AnswerController {
  private final NotificationService notificationService;

  @RequestMapping(value = "/answer", method = GET)
  public ModelAndView answerPage() {
    return new ModelAndView("pages/root");
  }

  @RequestMapping(value = "/answer", method = POST)
  public ResponseEntity answerAPI(@RequestBody Answer answer) {
    log.info("{} answer: {}", answer.getOperatorId(), answer);

    notificationService.notify(answer);

    return ResponseEntity.ok().build();
  }

  @RequestMapping(value = "/answer.sse")
  public SseEmitter answerJson() throws IOException {
    SseEmitter sseEmitter = new SseEmitter();
    notificationService.addEmitter(sseEmitter);

    sseEmitter.onCompletion(() -> {
      log.info(FIRE_ICON + " destroy emitter"); // fire utf-8 icon
      notificationService.removeEmitter(sseEmitter);
    });

    sseEmitter.onTimeout(() -> log.info(PIG_ICON + " timeout")); // pig utf-8 icon
    notificationService.notify(Answer.builder()
        .operatorId(MARTIAN_ICON) // martian utf-8 icon
        .answer(DANCING_MAN_ICON + " Connected") // dancing man utf-8 icon
        .build());

    return sseEmitter;
  }
}
