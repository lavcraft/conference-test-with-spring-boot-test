package com.conference.spring.test.service;

import com.conference.spring.reco.Slowrecommendation.Answer;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static com.conference.spring.reco.Slowrecommendation.Question;

/**
 * @author tolkv
 * @version 22/03/2017
 */
@Data
@Builder
@AllArgsConstructor
public class QuestionWithIssuer {
  final Question question;
  final StreamObserver<Answer> issuer;
}
