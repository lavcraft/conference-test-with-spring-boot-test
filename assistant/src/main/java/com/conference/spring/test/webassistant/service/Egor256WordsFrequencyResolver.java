package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.domain.QuestionType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.conference.spring.test.webassistant.domain.QuestionType.YEGOR256;

/**
 * Created by Evegeny on 28/03/2017.
 */
@Component
public class Egor256WordsFrequencyResolver extends AbstractWordsFrequencyResolver {
    @Getter
    @Value("${tokens.yegor256}")
    private String answers;


    @Override
    public QuestionType getQuestionType() {
        return YEGOR256;
    }
}
