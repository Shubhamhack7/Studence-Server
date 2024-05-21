package com.tiwari.studence.common.service.v2.helper;

import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.proto.match.*;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Singleton;

@Singleton
public class MultiSourcePriorityHelper {
  public boolean shouldOverride(MetaInfoPb metaInfo, String soureRef) throws ErrorException {
    KnownSourceUiEnum matchedSource = KnownSourceUiEnum.UNKNOWN_SOURCE;
    for (MatchInfoPb matchInfo : metaInfo.getMatchInfoList()) {
      if (matchInfo.getMatchInfo() == MatchInfoUiEnum.MATCH) {
        KnownSourceUiEnum source = getKnownSource(soureRef);
        if (isHigher(matchedSource, source)) {
          matchedSource = source;
        }
      }
    }
    KnownSourceUiEnum newSource = getKnownSource(soureRef);
    return isHigher(matchedSource, newSource);
  }

  private boolean isHigher(KnownSourceUiEnum source, KnownSourceUiEnum toCompare) {
    if (source == KnownSourceUiEnum.UNKNOWN_SOURCE) {
      return true;
    }
    if (source == KnownSourceUiEnum.GOOGLE_MAPS) {
      return toCompare == KnownSourceUiEnum.GOOGLE_MAPS || toCompare == KnownSourceUiEnum.MODERATOR
              || toCompare == KnownSourceUiEnum.SELF;
    }
    if (source == KnownSourceUiEnum.PRACTO) {
      return toCompare == KnownSourceUiEnum.PRACTO || toCompare == KnownSourceUiEnum.MODERATOR
              || toCompare == KnownSourceUiEnum.SELF;
    }
    if (source == KnownSourceUiEnum.MODERATOR) {
      return toCompare == KnownSourceUiEnum.MODERATOR || toCompare == KnownSourceUiEnum.SELF;
    }
    if (source == KnownSourceUiEnum.SELF) {
      return toCompare == KnownSourceUiEnum.SELF;
    }
    Preconditions.check(false, source, toCompare);
    return false;
  }

  public KnownSourceUiEnum getKnownSource(String sourceRefId) throws ErrorException {
    if (sourceRefId.startsWith(KnownSourceUiEnum.SELF.name())) {
      return KnownSourceUiEnum.SELF;
    }
    if (sourceRefId.startsWith(KnownSourceUiEnum.MODERATOR.name())) {
      return KnownSourceUiEnum.MODERATOR;
    }
    if (sourceRefId.startsWith(KnownSourceUiEnum.GOOGLE_MAPS.name())) {
      return KnownSourceUiEnum.GOOGLE_MAPS;
    }
    if (sourceRefId.startsWith(KnownSourceUiEnum.PRACTO.name())) {
      return KnownSourceUiEnum.PRACTO;
    }
    Preconditions.validate(false, ErrorTypePbEnum.VALIDATION_FAILED, sourceRefId);
    return KnownSourceUiEnum.UNKNOWN_SOURCE;
  }

}
