package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;

/**
 * Created by Evegeny on 28/03/2017.
 */
public interface AssistantServiceJavaGuruBackend {
    //TODO @jeka. Avoid switch logic
    Answer handleQuestion(Question question);
}
