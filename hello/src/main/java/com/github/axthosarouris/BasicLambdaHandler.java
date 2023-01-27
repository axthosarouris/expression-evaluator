package com.github.axthosarouris;

import static nva.commons.core.attempt.Try.attempt;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import nva.commons.core.ioutils.IoUtils;

public abstract class BasicLambdaHandler<I, O> implements RequestStreamHandler {

  private final Class<I> inputClass;

  protected BasicLambdaHandler(Class<I> inputClass) {
    this.inputClass = inputClass;
  }

  @Override
  public void handleRequest(InputStream input, OutputStream outputStream, Context context) {
    var inputString = IoUtils.streamToString(input);
    var inputObject = parseInput(inputString);
    O outputObject = processInput(inputObject, context);
    writeResponse(outputObject, outputStream);

  }

  protected abstract O processInput(I inputObject, Context context);

  protected I parseInput(String inputString) {
    return attempt(() -> JsonConfig.json.readValue(inputString, inputClass)).orElseThrow();
  }

  private void writeResponse(O response, OutputStream outputStream) {
    try (var writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
      var outputString = JsonConfig.json.writeValueAsString(response);
      writer.append(outputString);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
