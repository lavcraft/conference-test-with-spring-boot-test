package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.common.utils.WordsComposer;
import com.conference.spring.test.webassistant.domain.QuestionType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.conference.spring.test.webassistant.domain.QuestionType.JBARUCH;

/**
 * @author Evegeny
 * @version 28/03/2017
 */
@Component
public class JBaruchWordsFrequencyResolver extends AbstractWordsFrequencyResolver {
  @Getter
  @Value("${tokens.jbaruch}")
  private String answers;

  public JBaruchWordsFrequencyResolver(WordsComposer wordsComposer) {
    super(wordsComposer);
  }

  @Override
  public QuestionType getQuestionType() {
    return JBARUCH;
  }
}
