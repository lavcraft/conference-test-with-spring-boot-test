package com.conference.spring.test.jbaruch;

import com.conference.spring.test.common.utils.AnswerComposer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.conference.spring.test.common.utils.IconConstants.JBARUCH_ICON;

/**
 * @author tolkv
 * @version 20/03/2017
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FastAndTruthService {
  private final JBaruchProperties jBaruchProperties;
  private final AnswerComposer answerComposer;
  private AtomicLong atomicLong = new AtomicLong();

  public Answer handleQuestion(QuestionRequest question) {
    List<String> answers = jBaruchProperties.getAnswers();

    String answerText = answerComposer.giveAnswerText(answers, question.getBody());
    return Answer.builder()
        .id(String.valueOf(atomicLong.incrementAndGet()))
        .questionId(question.getId())
        .operatorId(JBARUCH_ICON)
        .answer(answerText)
        .build();
  }

}
