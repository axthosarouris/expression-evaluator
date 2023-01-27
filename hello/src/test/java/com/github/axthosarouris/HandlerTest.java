package com.github.axthosarouris;

import static no.unit.nva.testutils.RandomDataGenerator.randomString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.amazonaws.services.lambda.runtime.Context;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import nva.commons.core.ioutils.IoUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandlerTest {

  private static final Context CONTEXT = mock(Context.class);
  private Handler handler;
  private ByteArrayOutputStream output;

  private static InputStream sampleEvent() {
    var event = new InputEvent(randomString(), randomString());
    return IoUtils.stringToStream(event.toJsonString());
  }

  @BeforeEach
  public void init() {
    var kinesis = new FakeKinesisClient();
    this.output = new ByteArrayOutputStream();
    this.handler = new Handler(kinesis);
  }

  @Test
  void shouldPutRecordIntoKinesisStream() {
    var event = sampleEvent();
    handler.handleRequest(event, output, CONTEXT);
    var shardId = parseOutput();
    assertThat(shardId).isNotNull();

  }

  private String parseOutput() {
    return output.toString();
  }

}