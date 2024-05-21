package com.tiwari.studence.common.service.v2.extractor;

import com.google.protobuf.GeneratedMessageV3;

import java.util.List;

public abstract class AExternalIdsExtractor<UiPb extends GeneratedMessageV3> {
  public abstract List<String> getExternalIds(UiPb uiPb);
}
