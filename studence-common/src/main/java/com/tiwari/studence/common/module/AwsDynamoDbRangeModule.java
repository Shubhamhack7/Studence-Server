package com.tiwari.studence.common.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.tiwari.studence.common.provider.AwsDynamoDbRegionProvider;
import com.tiwari.studence.common.service.v2.aws.IAwsDynamoDbRegionProvider;

@Singleton
public class AwsDynamoDbRangeModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(IAwsDynamoDbRegionProvider.class).to(AwsDynamoDbRegionProvider.class);
  }
}

