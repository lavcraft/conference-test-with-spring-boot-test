package com.conference.spring.test.yegor256.service;

import com.conference.spring.test.yegor256.client.JBaruchClient;
import com.conference.spring.test.yegor256.client.Yegor256Client;
import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author tolkv
 * @version 22/03/2017
 */
@Slf4j
@Service("composite.assistant")
@RequiredArgsConstructor
public class AssistantServiceJavaGuruBackend implements AssistantService {
  private final AnswerCacheService answerCacheService;
  private final QuestionTypeResolver questionTypeResolver;
  private final JBaruchClient JBaruchClient;
  private final Yegor256Client yegor256Client;

  @Override
  public Answer handleQuestion(Question question) {
    // only for jbaruch
    Optional<Answer> answer = answerCacheService.find(question);

    return answer.orElseGet(() -> {
      QuestionType questionType = questionTypeResolver.resolveType(question);

      if (isJBaruchQuestion(questionType)) {
        return JBaruchClient.handleQuestion(question);
      }

      return yegor256Client.handleQuestion(question);
    });
  }

  private boolean isJBaruchQuestion(QuestionType questionType) {
    return questionType == QuestionType.JBARUCH;
  }
}
