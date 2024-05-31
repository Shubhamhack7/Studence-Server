package com.tiwari.studence.s3storage.provider;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import static com.amazonaws.services.resiliencehub.model.DisruptionType.Region;

public class S3storageConnectorProvider {

  String accountId = "YOUR_ACCOUNT_ID";
  String applicationKey = "YOUR_APPLICATION_KEY";
  String bucketName = "YOUR_BUCKET_NAME";
  String endpoint = "w1s2.va.idrivee2-59.com"; // Adjust region if needed


  public AmazonS3 getS3Object(){

      // Generate temporary credentials from Backblaze B2 API
      // ... Obtain credentials securely

      // Create an AmazonS3Client using the temporary credentials
    AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(new AWSCredentials() {
      @Override
      public String getAWSAccessKeyId() {
        return "lh5JI30PDsV9Okm08fzs";
      }

      @Override
      public String getAWSSecretKey() {
        return "0DlFdFFb8rZn9ODIpZFOk5Vd0fSRjvcZMnlZRsH4";
      }
    });
    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withCredentials(credentialsProvider)
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, "US_WEST_002"))
            .build();
      return s3Client;
    }

}
