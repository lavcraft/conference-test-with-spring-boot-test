package com.conference.spring.test.webassistant.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author tolkv
 * @version 27/03/2017
 */
@Entity
@Data
@Builder
@AllArgsConstructor
public class QuestionEntity {
  @Id
  @GeneratedValue(strategy = AUTO)
  private String id;
  private String text;
}
