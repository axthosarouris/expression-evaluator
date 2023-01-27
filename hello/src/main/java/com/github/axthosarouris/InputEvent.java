package com.github.axthosarouris;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class InputEvent implements JsonSerializable {

  public static final String NAME_FIELD = "name";
  public static final String VALUE_FIELD = "value";
  @JsonProperty(NAME_FIELD)
  private final String name;
  @JsonProperty(VALUE_FIELD)
  private final String value;

  @JsonCreator
  public InputEvent(@JsonProperty(NAME_FIELD) String name,
    @JsonProperty(VALUE_FIELD) String value) {
    this.name = name;
    this.value = value;
  }

  @JacocoGenerated
  public String getName() {
    return name;
  }

  @JacocoGenerated
  public String getValue() {
    return value;
  }

  @JacocoGenerated
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputEvent that = (InputEvent) o;
    return Objects.equals(name, that.name) && Objects.equals(value, that.value);
  }

  @JacocoGenerated
  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }

  @Override
  public String toString() {
    return toJsonString();
  }

  public String hashString() {
    return String.valueOf(hashCode());
  }

}
