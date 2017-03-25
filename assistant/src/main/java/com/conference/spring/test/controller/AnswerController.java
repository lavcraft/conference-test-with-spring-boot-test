package com.conference.spring.test.controller;

import com.conference.spring.test.domain.Answer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author tolkv
 * @version 23/03/2017
 */
@Slf4j
@Controller
public class AnswerController {
  private List<SseEmitter> emitters = new ArrayList<>();

  //TODO fix this
  @RequestMapping(value = "/answer", method = GET)
  public ModelAndView answerPage() {
    return new ModelAndView("pages/root");
  }

  @RequestMapping(value = "/answer", method = POST)
  public ResponseEntity answerAPI(@RequestBody Answer answer) {
    log.info("aaaa {}", answer);
    emitters.forEach(sseEmitter -> {
      try {
        sseEmitter.send(SseEmitter.event().comment("TEST").id("1").name("fds1"));
        sseEmitter.send(SseEmitter.event().comment("TEST1").id("2").name("fds2"));
        sseEmitter.send(SseEmitter.event().comment("TEST2").id("3").name("fds3"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    return ResponseEntity.ok("");
  }

  @RequestMapping(value = "/answer.sse")
  public SseEmitter answerJson() throws IOException {
    SseEmitter sseEmitter = new SseEmitter();
    emitters.add(sseEmitter);

    sseEmitter.onCompletion(() -> {
      log.info("completed");
      emitters.remove(sseEmitter);
    });

    sseEmitter.onTimeout(() -> log.info("timeout"));
    sseEmitter.send(SseEmitter.event().comment("TEST").id("1"));
    return sseEmitter;
  }
}
