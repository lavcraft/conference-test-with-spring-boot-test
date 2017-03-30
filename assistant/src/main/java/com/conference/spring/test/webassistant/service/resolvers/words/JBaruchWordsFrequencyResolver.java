package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.common.utils.WordsComposer;
import com.conference.spring.test.webassistant.domain.QuestionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.conference.spring.test.webassistant.domain.QuestionType.JBARUCH;

/**
 * Created by Evegeny on 28/03/2017.
 */
@Component
@RequiredArgsConstructor
public class JBaruchWordsFrequencyResolver extends AbstractWordsFrequencyResolver {
  private final WordsComposer wordsComposer;

  @Getter
  @Value("${tokens.jbaruch}")
  private String answers;

  @Override
  public QuestionType getQuestionType() {
    return JBARUCH;
  }

  @Override
  protected List<String> getWords(String text) {
    return wordsComposer.extractWordsWithoutGarbage(text);
  }
}
