package com.github.axthosarouris;

import static nva.commons.core.attempt.Try.attempt;

public interface JsonSerializable {

  default String toJsonString() {
    return attempt(() -> JsonConfig.json.writeValueAsString(this)).orElseThrow();
  }

}
