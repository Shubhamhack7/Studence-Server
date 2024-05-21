package com.tiwari.studence.common.service.v2.aws;

import com.amazonaws.regions.Regions;

public interface IAwsDynamoDbRegionProvider {

  public Regions getRegion();

}
