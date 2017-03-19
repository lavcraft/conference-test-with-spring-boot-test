package com.conference.spring.test;

import com.conference.spring.reco.RecommendationServiceGrpc;
import com.conference.spring.reco.RecommendationServiceGrpc.RecommendationServiceStub;
import com.conference.spring.reco.Slowrecommendation.Question;
import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.conference.spring.reco.Slowrecommendation.Answer;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@Slf4j
public class ConsoleSingleRoomChat {
  public static void main(String[] args) {
    StreamObserver<Question> client = configureRecommendationClient("127.0.0.1", 10101);

    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(System.in));

      while (true) {
        System.out.print("Enter something [q-quit]: ");
        String input = br.readLine();

        if ("q".equals(input)) {
          System.out.println("Exit!");
          System.exit(0);
        }

        client.onNext(Question.newBuilder()
            .setBody(input)
            .build());

        System.out.println("input : " + input);
        System.out.println("-----------\n");
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  private static StreamObserver<Question> configureRecommendationClient(String host, int port) {
    ManagedChannel channel = NettyChannelBuilder.forAddress(host, port)
        .usePlaintext(true)
        .build();

    RecommendationServiceStub recommendationServiceStub = RecommendationServiceGrpc.newStub(channel);
    return recommendationServiceStub.streamRecommendation(new StreamObserver<Answer>() {
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
    });
  }
}
