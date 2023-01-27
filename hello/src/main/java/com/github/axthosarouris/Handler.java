package com.github.axthosarouris;

import com.amazonaws.services.lambda.runtime.Context;
import java.nio.charset.StandardCharsets;
import nva.commons.core.Environment;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kinesis.KinesisClient;
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest;
import software.amazon.awssdk.services.kinesis.model.PutRecordResponse;

public class Handler extends BasicLambdaHandler<InputEvent, String> {

  public static final Environment ENV = new Environment();
  public static final Region REGION = ENV.readEnvOpt("AWS_REGION")
                                         .map(Region::of)
                                         .orElseThrow();
  private static final String KINESIS_STREAM = ENV.readEnv("KINESIS_STREAM");
  private final KinesisClient kinesisClient;

  @JacocoGenerated
  public Handler() {
    this(defaultClient());
  }

  public Handler(KinesisClient kinesisClient) {
    super(InputEvent.class);
    this.kinesisClient = kinesisClient;
  }

  @Override
  public String processInput(InputEvent input, Context context) {
    var kinesisResponse = appendToKinesisStream(input);
    return kinesisResponse.shardId();

  }

  @JacocoGenerated
  private static KinesisClient defaultClient() {
    return KinesisClient.builder()
                        .region(REGION)
                        .credentialsProvider(DefaultCredentialsProvider.create())
                        .httpClient(UrlConnectionHttpClient.create())
                        .build();
  }

  private static PutRecordRequest cratePutKinesisRequest(InputEvent input) {
    var data = SdkBytes.fromString(input.toString(), StandardCharsets.UTF_8);
    return PutRecordRequest.builder()
                           .partitionKey(input.hashString())
                           .streamName(KINESIS_STREAM)
                           .data(data)
                           .build();
  }

  private PutRecordResponse appendToKinesisStream(InputEvent inputEvent) {
    var request = cratePutKinesisRequest(inputEvent);
    return kinesisClient.putRecord(request);
  }


}
