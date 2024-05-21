package com.tiwari.studence.common.provider;

import com.amazonaws.regions.Regions;
import com.tiwari.studence.common.service.v2.aws.IAwsDynamoDbRegionProvider;

public class AwsDynamoDbRegionProvider implements IAwsDynamoDbRegionProvider {
  @Override
  public Regions getRegion() {
    return Regions.US_WEST_2;
  }
}
