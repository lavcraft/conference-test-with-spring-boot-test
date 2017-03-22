package com.conference.spring.test;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import static com.conference.spring.reco.Slowrecommendation.Answer;

/**
 * @author tolkv
 * @version 22/03/2017
 */
@Slf4j
public class ChatHandler implements StreamObserver<Answer> {
  @Override
  public void onNext(Answer answer) {
    log.info("Answer: {}", answer);
  }

  @Override
  public void onError(Throwable throwable) {
    log.error("Error:", throwable);
  }

  @Override
  public void onCompleted() {
    log.info("completed");
  }
}
