package com.conference.spring.test.service;

import com.conference.spring.reco.RecommendationServiceGrpc;
import com.conference.spring.reco.Slowrecommendation.Answer;
import com.conference.spring.reco.Slowrecommendation.Question;
import com.conference.spring.test.RecommendationApplication;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.grpc.spring.boot.autoconfigure.annotation.GRPCLocalPort;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RecommendationApplication.class)
public class SlowRecommendationServiceTest {
  ManagedChannel channel;
  @GRPCLocalPort
  int port;
  @Autowired
  ApplicationContext applicationContext;

  @Before
  public void setup() {
    channel = NettyChannelBuilder.forAddress("127.0.0.1", port)
        .usePlaintext(true)
        .build();
  }

  @Test
  public void should_get_recommendation() throws InterruptedException {
    assertThat(applicationContext, notNullValue());
    RecommendationServiceGrpc.RecommendationServiceStub recommendationServiceStub = RecommendationServiceGrpc.newStub(channel);

    CountDownLatch countDownLatch = new CountDownLatch(5);
    StreamObserver<Question> client = recommendationServiceStub.streamRecommendation(new StreamObserver<Answer>() {
      @Override
      public void onNext(Answer answer) {
        log.info("Answer: {}", answer);
        countDownLatch.countDown();
      }

      @Override
      public void onError(Throwable throwable) {
        log.error("Error:", throwable);
      }

      @Override
      public void onCompleted() {
        log.info("completed");
      }
    });

    IntStream.range(0, 5)
        .forEach(value -> client.onNext(Question.newBuilder()
            .setId(String.valueOf(value))
            .build())
        );

    countDownLatch.await(10, TimeUnit.SECONDS);


    assertThat(countDownLatch.getCount(), equalTo(0L));
  }
}