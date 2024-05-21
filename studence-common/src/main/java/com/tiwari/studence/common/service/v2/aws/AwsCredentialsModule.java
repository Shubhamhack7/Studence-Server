package com.tiwari.studence.common.service.v2.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.google.inject.*;

@Singleton
public class AwsCredentialsModule extends AbstractModule {
  public enum AwsAccount {
    DEVEL,
    QA,
    PRODTEST,
    PROD
  }

  @Override
  protected void configure() {
    bind(AWSCredentials.class).toProvider(AwsCredentialsProvider.class).in(Singleton.class);
  }

}

class AwsCredentialsProvider implements Provider<AWSCredentials> {

  // Inject dependencies for retrieving credentials (e.g., environment variables, configuration files)
  @Inject
  public AwsCredentialsProvider( /* Your credential retrieval logic */) {
    // Implement logic to retrieve access key ID and secret key based on environment or configuration
  }

  @Override
  public AWSCredentials get() {
    String accessKeyId = "DUMMYIDEXAMPLE"/* Get access key ID from injected dependencies */;
    String secretKey = "DUMMYEXAMPLEKEY"/* Get secret key from injected dependencies */;
    return new BasicAWSCredentials(accessKeyId, secretKey);
  }
}