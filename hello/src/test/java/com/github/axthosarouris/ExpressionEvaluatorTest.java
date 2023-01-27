package com.github.axthosarouris;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ExpressionEvaluatorTest {

  public static Stream<Arguments> expressionProvider() {
    return Stream.of(
      Arguments.of("15 + 3", 18),
      Arguments.of("5 - 3", 2),
      Arguments.of("15 * 3", 45),
      Arguments.of("15 / 3", 5));
  }

  public static Stream<Arguments> multiOperatorExpressionProvider() {
    return Stream.of(
      Arguments.of("1 + 5 + 3", 9),
      Arguments.of("1 + 5 - 3", 3),
      Arguments.of("1 + 5 + 3 + 1", 10),
      Arguments.of("(1 + 5) * 3", 18),
      Arguments.of("1 + (5 * 3)", 16)
    );
  }

  @ParameterizedTest(name = "{0}={1}")
  @MethodSource("expressionProvider")
  void shouldReturnResultOfOneOperatorExpressions(String expression, Integer expectedResult) {
    var actualResult = new ExpressionEvaluator(expression).evaluate();
    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest(name = "{0}={1}")
  @MethodSource("multiOperatorExpressionProvider")
  void shouldReturnResultOfMultiOperatorExpressions(String expression, Integer expectedResult) {
    var actualResult = new ExpressionEvaluator(expression).evaluate();
    assertThat(actualResult).isEqualTo(expectedResult);
  }
}

