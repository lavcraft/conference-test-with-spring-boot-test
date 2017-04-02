package com.conference.spring.test.webassistant.service.resolvers.question;

import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;
import com.conference.spring.test.webassistant.service.resolvers.ResolversAbstractCommonConfiguration;
import com.conference.spring.test.webassistant.service.resolvers.WordsCommonConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import static com.conference.spring.test.webassistant.domain.QuestionType.JBARUCH;
import static com.conference.spring.test.webassistant.domain.QuestionType.YEGOR256;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author tolkv
 * @version 30/03/2017
 */
@RunWith(SpringRunner.class)
@ContextHierarchy(value = {
    @ContextConfiguration(classes = WordsCommonConfiguration.class),
    @ContextConfiguration(classes = TextBasedQuestionTypeResolverTestConfiguration.class),
})
public class TextBasedQuestionTypeResolverTest extends ResolversAbstractCommonConfiguration {
  @Autowired
  TextBasedQuestionTypeResolver textBasedQuestionTypeResolver;
  @Value("${tokens.jbaruch}")
  String stringjb;
  @Value("${tokens.yegor256}")
  String stringyegor;

  @Test
  public void should_sth() throws Exception {
    QuestionType jbaruchType = textBasedQuestionTypeResolver.resolveType(Question.builder()
        .body("groovy in object is sexy?")
        .build());

    QuestionType yegorType = textBasedQuestionTypeResolver.resolveType(Question.builder()
        .body("fall in love with objects?")
        .build());

    assertThat(jbaruchType, equalTo(JBARUCH));
    assertThat(yegorType, equalTo(YEGOR256));
  }

}