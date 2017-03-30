package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;

/**
 * Created by Evegeny on 28/03/2017.
 */
public interface WordsFrequencyResolver {
    int match(Question question);
    QuestionType getQuestionType();
}
