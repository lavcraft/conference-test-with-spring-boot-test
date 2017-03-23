package com.conference.spring.test.service;

import com.conference.spring.reco.Slowrecommendation;
import com.conference.spring.test.client.JBaruchClient;
import com.conference.spring.test.client.Yegor256Client;
import com.conference.spring.test.domain.Answer;
import com.conference.spring.test.domain.Question;
import com.conference.spring.test.domain.QuestionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Optional;

/**
 * @author tolkv
 * @version 22/03/2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AssistantServiceJavaGuruBackend implements AssistantService {
  private final AnswerCacheService answerCacheService;
  private final QuestionTypeResolver questionTypeResolver;
  private final JBaruchClient JBaruchClient;
  private final Yegor256Client yegor256Client;

  @Override
  public Answer handleQuestion(Question question) {
    Optional<Answer> answer = answerCacheService.find(question);

    return answer.orElseGet(() -> {
      QuestionType questionType = questionTypeResolver.resolveType(question);

      if (questionType == QuestionType.GROOVY) {
        return JBaruchClient.handleQuestion(question);
      }

      return yegor256Client.handleQuestion(question, new ListenableFutureCallback<Slowrecommendation.Answer>() {
        @Override
        public void onFailure(Throwable ex) {

        }

        @Override
        public void onSuccess(Slowrecommendation.Answer result) {

        }
      });
    });
  }
}
