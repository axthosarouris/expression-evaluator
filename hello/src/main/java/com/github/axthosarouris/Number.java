package com.github.axthosarouris;

public class Number implements Expression {

  private final int value;

  public Number(int value) {
    this.value = value;
  }

  public static Number parseNumber(String number) {
    return new Number(Integer.parseInt(number));
  }

  @Override
  public int evaluate() {
    return value;
  }
}
