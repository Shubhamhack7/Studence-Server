package com.tiwari.studence.common.service.v2.extractor;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.util.collect.Lists;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class NoExternalIdExtractor<UiPb extends GeneratedMessageV3> extends
        AExternalIdsExtractor<UiPb> {
  @Override
  public List<String> getExternalIds(GeneratedMessageV3 uiPb) {
    return Lists.emptyList();
  }
}
