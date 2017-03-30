package com.conference.spring.test.webassistant.service.resolvers.question;

import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;
import com.conference.spring.test.webassistant.service.resolvers.WordsCommonConfiguration;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import static com.conference.spring.test.webassistant.domain.QuestionType.JBARUCH;
import static com.conference.spring.test.webassistant.domain.QuestionType.YEGOR256;
import static org.junit.Assert.assertThat;

/**
 * @author tolkv
 * @version 30/03/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextHierarchy({
    @ContextConfiguration(classes = WordsCommonConfiguration.class),
    @ContextConfiguration(classes = TextBasedQuestionTypeResolverTestConfiguration.class),
})
//@ContextConfiguration(classes = TextBasedQuestionTypeResolverTestConfiguration.class)
@ActiveProfiles("yegor_vs_jbaruch")
public class TextBasedQuestionTypeResolverTest {
  @Autowired
  TextBasedQuestionTypeResolver textBasedQuestionTypeResolver;
  @Value("${tokens.jbaruch}")
  String stringjb;

  @Test
  public void should_sth() throws Exception {
    QuestionType jbaruchType = textBasedQuestionTypeResolver.resolveType(Question.builder()
        .body("groovy in object is sexy?")
        .build());

    QuestionType yegorType = textBasedQuestionTypeResolver.resolveType(Question.builder()
        .body("fall in love with objects?")
        .build());

    assertThat(jbaruchType, CoreMatchers.equalTo(JBARUCH));
    assertThat(yegorType, CoreMatchers.equalTo(YEGOR256));
  }
}