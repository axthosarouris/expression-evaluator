package com.github.axthosarouris;

import static no.unit.nva.testutils.RandomDataGenerator.randomString;

import software.amazon.awssdk.services.kinesis.KinesisClient;
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest;
import software.amazon.awssdk.services.kinesis.model.PutRecordResponse;

public class FakeKinesisClient implements KinesisClient {

  @Override
  public String serviceName() {
    return "kinesis";
  }

  @Override
  public PutRecordResponse putRecord(PutRecordRequest putRecordRequest) {
    return PutRecordResponse.builder().shardId(randomString()).build();

  }

  @Override
  public void close() {
    // NO-OP
  }
}
