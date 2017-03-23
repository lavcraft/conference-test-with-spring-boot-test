package com.conference.spring.test.service;

import com.conference.spring.reco.RecommendationServiceGrpc;
import com.conference.spring.reco.Slowrecommendation;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.conference.spring.reco.Slowrecommendation.Answer;
import static com.conference.spring.reco.Slowrecommendation.Question;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@Slf4j
//@GRpcService
public class SlowRecommendationService extends RecommendationServiceGrpc.RecommendationServiceImplBase {
  private BlockingQueue<QuestionWithIssuer> questionsQueue = new ArrayBlockingQueue<>(10);

  @Scheduled(cron = "*/2 * * * * ?")
  public void scheduler() {
    QuestionWithIssuer poll = questionsQueue.poll();

    if (poll != null && poll.getIssuer() != null) {
      log.info("Question: {}", poll.getQuestion().getBody());
      log.info("Egor thinking...");
      log.info("Egor answering... {}");
      poll.getIssuer().onNext(Answer.newBuilder()
          .setId(poll.getQuestion().getId())
          .setAnswer(poll.getQuestion().getBody() + generateAnswer())
          .build());
    } else {
      log.info("Egor waiting...");
    }
  }

  // TODO сделать веселый список ответов Егора
  private String generateAnswer() {
    return " – yes";
  }

  @Override
  public StreamObserver<Slowrecommendation.Question> streamRecommendation(StreamObserver<Slowrecommendation.Answer> responseObserver) {
    return new StreamObserver<Slowrecommendation.Question>() {
      @Override
      public void onNext(Question question) {
        log.info("Add question to yegor256 queue and wait...");
        questionsQueue.add(new QuestionWithIssuer(question, responseObserver));
      }

      @Override
      public void onError(Throwable throwable) {
        log.error("server error", throwable);
      }

      @Override
      public void onCompleted() {
        log.error("server: completed. Question count: {}", questionsQueue.remainingCapacity());
      }
    };
  }

  @Override
  public void getRecommendation(Question request, StreamObserver<Slowrecommendation.Answer> responseObserver) {
    super.getRecommendation(request, responseObserver);
  }
}
