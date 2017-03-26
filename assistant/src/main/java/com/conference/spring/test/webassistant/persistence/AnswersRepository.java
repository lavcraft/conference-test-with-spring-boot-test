package com.conference.spring.test.webassistant.persistence;

import org.springframework.data.repository.CrudRepository;

/**
 * @author tolkv
 * @version 27/03/2017
 */
public interface AnswersRepository extends CrudRepository<AnswerEntity, String> {

}
