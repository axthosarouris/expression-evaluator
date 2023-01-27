package com.github.axthosarouris;

import java.util.List;

public class ComplexExpression implements Expression {

  private final Expression leftOperand;
  private final Expression rightOperand;
  private final Operator operator;

  public ComplexExpression(Expression leftOperand, Expression rightOperand, Operator operator) {
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
    this.operator = operator;
  }

  public static ComplexExpression parseExpression(List<String> expressionParts) {

    var leftOperand = Number.parseNumber(expressionParts.get(0));
    var rightOperand = Number.parseNumber(expressionParts.get(2));
    var operator = new Operator(expressionParts.get(1));
    var expression = new ComplexExpression(leftOperand, rightOperand, operator);
    var currentIndex = 2;

    while (currentIndex < expressionParts.size() - 1) {
      var operator2 = new Operator(expressionParts.get(currentIndex + 1));
      var rightOperand2 = Number.parseNumber(expressionParts.get(currentIndex+2));
      expression = new ComplexExpression(expression, rightOperand2, operator2);
      currentIndex += 2;
    }
    return expression;

  }

  public int evaluate() {
    return operator.apply(leftOperand.evaluate(), rightOperand.evaluate());
  }



  private static class ExpressionExtractor {

    public final ComplexExpression expression;
    public final List<String> remainingExpression;

    public ExpressionExtractor(ComplexExpression expression, List<String> remainingExpression) {
      this.expression = expression;
      this.remainingExpression = remainingExpression;
    }
  }
}
