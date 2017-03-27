package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.client.JBaruchClient;
import com.conference.spring.test.webassistant.client.Yegor256Client;
import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  private final JBaruchClient jbaruchClient;
  private final Yegor256Client yegor256Client;
  private Map<QuestionType, AssistantService> questionTypeAssistantServiceMap = new HashMap<>();

  @Autowired
  private void initMap(List<AssistantService> assistantServiceList) {
    assistantServiceList.forEach(assistantService -> {

    });
  }

  //TODO @jeka. Avoid switch logic
  @Override
  public Answer handleQuestion(Question question) {
    // only for jbaruch
    Optional<Answer> answer = answerCacheService.find(question);

    return answer.orElseGet(() -> {
      QuestionType questionType = questionTypeResolver.resolveType(question);

      if (isJBaruchQuestion(questionType)) {
        return jbaruchClient.handleQuestion(question);
      }

      return yegor256Client.handleQuestion(question);
    });
  }

  @Override
  public QuestionType assistantName() {
    return QuestionType.OTHER;
  }

  private boolean isJBaruchQuestion(QuestionType questionType) {
    return questionType == QuestionType.JBARUCH;
  }
}
