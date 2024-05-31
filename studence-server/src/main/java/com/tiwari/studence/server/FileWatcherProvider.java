package com.tiwari.studence.server;

import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;
import com.google.cloud.functions.RawBackgroundFunction;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.firebase.cloud.StorageClient;


public class FileWatcherProvider implements RawBackgroundFunction {

  private static final String COLLECTION_NAME = "your-collection";

  @Override
  public void accept(String json, Context context) {

    BucketInfo bucket = StorageClient.getInstance().bucket("DEVELOPMENT").asBucketInfo();
    System.out.println(bucket.getLocation());
  }

}
