package com.tiwari.studence.common.service.v2.aws;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.google.inject.*;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.tiwari.studence.util.module.ExecutorModule;

import java.util.Set;

@Singleton
public class AwsDynamoDbAsyncClientModule extends AbstractModule {
  @Inject
  public AwsDynamoDbAsyncClientModule() {
  }

  @Override
  protected void configure() {
    bind(AmazonDynamoDBClient.class).toProvider(AmazonDynamoDbClientProvider.class).in(Singleton.class);
  }

}


class AmazonDynamoDbClientProvider implements Provider<AmazonDynamoDBClient> {

  private final AWSCredentials awsCredentials;
  private final IAwsDynamoDbRegionProvider regionProvider;

  @Inject
  public AmazonDynamoDbClientProvider(AWSCredentials awsCredentials, IAwsDynamoDbRegionProvider regionProvider) {
    this.awsCredentials = awsCredentials;
    this.regionProvider = regionProvider;
  }

  @Override
  public AmazonDynamoDBClient get() {
    ClientConfiguration clientConfiguration = new ClientConfiguration();
    clientConfiguration.setMaxConnections(5000);
    clientConfiguration.setUseGzip(true);
    clientConfiguration.setRequestTimeout(5000);
    clientConfiguration.setClientExecutionTimeout(15200);
    clientConfiguration.setSocketTimeout(5500);
    clientConfiguration.setMaxErrorRetry(3);
    clientConfiguration.setConnectionTimeout(1000);
    clientConfiguration.setConnectionTTL(15*60*1000);
    AmazonDynamoDBClient client = new AmazonDynamoDBClient(awsCredentials, clientConfiguration);
    client.setRegion(Region.getRegion(regionProvider.getRegion()));
    return client;
  }
}
