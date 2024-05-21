package com.tiwari.studence.common.service.v2.interfaces;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.proto.match.MatchInfoUiEnum;
import com.tiwari.studence.util.collect.Pair;

public interface IMatcher {
  public Pair<MatchInfoUiEnum, Integer> match(GeneratedMessageV3 first, GeneratedMessageV3 second);
}
