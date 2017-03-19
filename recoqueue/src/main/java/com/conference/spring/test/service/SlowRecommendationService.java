package com.conference.spring.test.service;

import com.conference.spring.reco.RecommendationServiceGrpc;
import com.conference.spring.reco.Slowrecommendation;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.grpc.spring.boot.autoconfigure.annotation.GRpcService;

import static com.conference.spring.reco.Slowrecommendation.*;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@Slf4j
@GRpcService
public class SlowRecommendationService extends RecommendationServiceGrpc.RecommendationServiceImplBase {
  @Override
  public StreamObserver<Slowrecommendation.Question> streamRecommendation(StreamObserver<Slowrecommendation.Answer> responseObserver) {
    return new StreamObserver<Slowrecommendation.Question>() {
      @Override
      public void onNext(Question question) {
        log.info("server onNext: {}", question);
        responseObserver.onNext(Answer.newBuilder()
            .setId(String.valueOf(question.getId()))
            .setAnswer(question.getBody()+" too")
            .build());
      }

      @Override
      public void onError(Throwable throwable) {
        log.error("server error", throwable);
      }

      @Override
      public void onCompleted() {
        log.error("server: completed");

      }
    };
  }

  @Override
  public void getRecommendation(Question request, StreamObserver<Slowrecommendation.Answer> responseObserver) {
    super.getRecommendation(request, responseObserver);
  }
}
