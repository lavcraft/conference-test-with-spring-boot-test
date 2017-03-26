package com.conference.spring.test.webassistant.persistence;

import com.conference.spring.test.webassistant.domain.Answer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author tolkv
 * @version 27/03/2017
 */
public interface AnswersRepository extends CrudRepository<Answer, String> {

}
