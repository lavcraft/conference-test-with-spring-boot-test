package com.conference.spring.test;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.concurrent.SettableListenableFuture;

import static com.conference.spring.reco.Slowrecommendation.Answer;

/**
 * @author tolkv
 * @version 22/03/2017
 */
@Slf4j
@RequiredArgsConstructor
public class ChatHandler implements StreamObserver<Answer> {
  private final SettableListenableFuture<Answer> future;

  @Override
  public void onNext(Answer answer) {
    log.info("Answer: {}", answer);
    future.set(answer);
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
