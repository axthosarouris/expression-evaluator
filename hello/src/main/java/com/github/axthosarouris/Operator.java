package com.github.axthosarouris;

public class Operator {

  private final String value;

  public Operator(String symbol) {
    this.value = symbol;
  }

  public int apply(int leftOperand, int rightOperand) {
    if ("+".equals(value)) {
      return leftOperand + rightOperand;
    }
    if ("-".equals(value)) {
      return leftOperand - rightOperand;
    }
    if ("*".equals(value)) {
      return leftOperand * rightOperand;
    }
    return leftOperand / rightOperand;

  }
}
