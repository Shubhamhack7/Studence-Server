package com.tiwari.studence.s3storage;

import com.amazonaws.services.s3.AmazonS3;
import com.tiwari.studence.s3storage.provider.S3storageConnectorProvider;
import com.tiwari.studence.util.serverConfig.ServerEnvironmentType;

public class S3StorageTest {
  public static void main(String[] args) {
    S3storageConnectorProvider provider = new S3storageConnectorProvider();
    AmazonS3 obj = provider.getS3Object();
    obj.createBucket(ServerEnvironmentType.DEVELOPMENT.name().toLowerCase());
  }
}
