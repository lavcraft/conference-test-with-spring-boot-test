package com.conference.spring.test.client;

import com.conference.spring.reco.Slowrecommendation;
import com.conference.spring.test.ChatHandler;
import com.conference.spring.test.domain.Answer;
import com.conference.spring.test.domain.Question;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SettableListenableFuture;

import static com.conference.spring.reco.RecommendationServiceGrpc.RecommendationServiceStub;

/**
 * @author tolkv
 * @version 22/03/2017
 */
@Service
@RequiredArgsConstructor
public class Yegor256Client {
  private final RecommendationServiceStub recommendationServiceStub;

  public Answer handleQuestion(Question question, ListenableFutureCallback<Slowrecommendation.Answer> callback) {

    SettableListenableFuture<Slowrecommendation.Answer> future = new SettableListenableFuture<>();
    future.addCallback(callback);

    StreamObserver<Slowrecommendation.Question> client =
        recommendationServiceStub.streamRecommendation(
            new ChatHandler(future)
        );

    Slowrecommendation.Question q = Slowrecommendation.Question.newBuilder()
        .setBody(question.getBody())
        .setId(question.getId())
        .setUserId(question.getUserId())
        .setQuestionType(Slowrecommendation.QuestionType.valueOf(question.getQuestionType().toString()))
        .build();

    client.onNext(q);

    return Answer.builder()
        .answer("TODO")
        .build();
  }
}
