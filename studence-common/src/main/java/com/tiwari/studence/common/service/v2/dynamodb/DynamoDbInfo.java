package com.tiwari.studence.common.service.v2.dynamodb;

import com.tiwari.studence.common.service.v2.interfaces.IDbInfo;

import javax.inject.Singleton;

@Singleton
public class DynamoDbInfo  implements IDbInfo {
  public int getDBMaxAttributesSize() {
    return 64*1024;
  }
}
