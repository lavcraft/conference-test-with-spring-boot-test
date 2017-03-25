package com.conference.spring.test.service;

import com.conference.spring.test.client.Answer;
import com.conference.spring.test.client.AssistantClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SlowRecommendationService {
  private final AssistantClient assistantClient;
  private BlockingQueue<Question> questionsQueue = new ArrayBlockingQueue<>(10);
  private AtomicLong atomicLong = new AtomicLong();

  @PostConstruct
  public void init() throws InterruptedException {
    //TODO read answers
  }

  @Scheduled(cron = "*/2 * * * * ?")
  public void scheduler() {
    try {
      Question poll = questionsQueue.poll();

      if (poll != null) {
        log.info("Question: {}", poll.getBody());
        log.info("Egor thinking...");
        log.info("Egor answering... {}");

        Answer answer = Answer.builder()
            .operatorId("yegor256")
            .id(String.valueOf(atomicLong.incrementAndGet()))
            .questionId(poll.getId())
            .build();

        assistantClient.answer(answer);
      } else {
        log.info("Egor waiting...");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // TODO сделать веселый список ответов Егора
  private String generateAnswer() {
    return " – yes";
  }

  public void addQuestion(Question question) {
    log.info("Add question to yegor256 queue and wait...");
    questionsQueue.add(question);
  }
}
