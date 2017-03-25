package com.conference.spring.test.service;

import com.conference.spring.test.Yegor256Properties;
import com.conference.spring.test.client.Answer;
import com.conference.spring.test.client.AssistantClient;
import com.conference.spring.test.common.utils.WordsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

import static com.conference.spring.test.common.utils.AnswerUtil.giveAnswer;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SlowRecommendationService {
  private final AssistantClient assistantClient;
  private final Yegor256Properties yegor256Properties;
  private BlockingQueue<Question> questionsQueue = new ArrayBlockingQueue<>(10);
  private AtomicLong atomicLong = new AtomicLong();

  static {
    log.trace("listUtils.class: ", WordsUtil.class);
  }

  @Scheduled(cron = "*/2 * * * * ?")
  public void scheduler() {
    try {
      Question poll = questionsQueue.poll();

      if (poll != null) {
        log.info("Question: {}", poll.getBody());
        log.info("Egor thinking...");
        log.info("Egor answering... {}");

        String answerText = giveAnswer(yegor256Properties.getAnswers(), poll.getBody());

        Answer answer = Answer.builder()
            .id(String.valueOf(atomicLong.incrementAndGet()))
            .questionId(poll.getId())
            .operatorId("yegor256")
            .answer(answerText)
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
