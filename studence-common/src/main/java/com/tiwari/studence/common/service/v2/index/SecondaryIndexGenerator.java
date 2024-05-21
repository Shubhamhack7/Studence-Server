package com.tiwari.studence.common.service.v2.index;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class SecondaryIndexGenerator<Pb extends GeneratedMessageV3> {

  public final Map<String, String> getAllSecondaryIndexes(Pb pb) {
    Map<String, String> createOrUpdateSecondaryIndexes = Maps.newHashMap();
    addAllSecondaryIndexes(pb, createOrUpdateSecondaryIndexes);
    for (Map.Entry<String, String> secondaryIndex : createOrUpdateSecondaryIndexes.entrySet()) {
      Preconditions.check(Strings.notEmpty(secondaryIndex.getKey()),
              "Secondary Index Key Name is empty", createOrUpdateSecondaryIndexes, pb);
      Preconditions.check(Strings.notEmpty(secondaryIndex.getValue()),
              "Secondary Index Key Value is empty", createOrUpdateSecondaryIndexes, pb);
      Preconditions.check(
              !Strings.areEqual(secondaryIndex.getKey(), EntityIndexAttributes.ITEM_ID.name()),
              "Secondary Index Key Name should not be same as " + EntityIndexAttributes.ITEM_ID.name(),
              createOrUpdateSecondaryIndexes, pb);
      Preconditions.check(
              !Strings.areEqual(secondaryIndex.getKey(), EntityIndexAttributes.RANGE_KEY.name()),
              "Secondary Index Key Name should not be same as " + EntityIndexAttributes.RANGE_KEY.name(),
              createOrUpdateSecondaryIndexes, pb);
    }
    return createOrUpdateSecondaryIndexes;
  }

  protected void addAllSecondaryIndexes(Pb pb, Map<String, String> createOrUpdateSecondaryIndexes) {

  }

}
