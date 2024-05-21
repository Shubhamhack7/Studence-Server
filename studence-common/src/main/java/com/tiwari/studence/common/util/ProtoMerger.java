package com.tiwari.studence.common.util;

import com.google.inject.Injector;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.helper.MultiSourcePriorityHelper;
import com.tiwari.studence.common.service.v2.interfaces.IMatcher;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.proto.match.*;
import com.tiwari.studence.proto.mergeOption.MergeOption;
import com.tiwari.studence.proto.time.TimePb;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.collect.Sets;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Singleton
public class ProtoMerger {

  private final ProtoMergerHelper m_mergerHelper;
  private final GNormalizedProto m_checkProtoProperty;
  private final ProtoHelper m_protoHelper;
  private final MultiSourcePriorityHelper m_multiSourceHelper;
  private final Injector m_injector;

  @Inject
  public ProtoMerger(ProtoMergerHelper mergerHelper, GNormalizedProto checkProtoProperty,
          ProtoHelper protoHelper, MultiSourcePriorityHelper multiSourceHelper, Injector injector) {
    m_mergerHelper = mergerHelper;
    m_checkProtoProperty = checkProtoProperty;
    m_protoHelper = protoHelper;
    m_multiSourceHelper = multiSourceHelper;
    m_injector = injector;
  }

  private enum MatchResult {
    CONSUMED,
    OVERRIDE,
    MATCH,
    NO_MATCH
  }

  public Pair<GeneratedMessageV3, MatchResult> merge(GeneratedMessageV3 toPb, GeneratedMessageV3 fromPb,
          String soureRef, TimePb matchTime, MetaInfoPb currentParentSourceRef, boolean isDiffUpdate)
          throws ErrorException {
    Preconditions.validate(toPb.getDescriptorForType().equals(fromPb.getDescriptorForType()),
            ErrorTypePbEnum.VALIDATION_FAILED, toPb.getDescriptorForType());
    Preconditions.validate(isDiffUpdate
                    || (m_multiSourceHelper.getKnownSource(soureRef) == KnownSourceUiEnum.SELF),
            ErrorTypePbEnum.VALIDATION_FAILED, toPb.getDescriptorForType());

    String messageOptionOverride = toPb.getDescriptorForType().getOptions()
            .getExtension(MergeOption.isBasicType);

    if (messageOptionOverride.equals("yes")) {
      return isBasicType(toPb, fromPb, soureRef, matchTime, currentParentSourceRef, isDiffUpdate);
    }
    MetaInfoPb metaInfo = m_protoHelper.getFieldByNumber(toPb, 13);

    boolean override = true;
    MetaInfoPb metaInfoForChildren = null;
    if (metaInfo != null || currentParentSourceRef != null) {
      Preconditions.validate(Strings.notEmpty(soureRef), ErrorTypePbEnum.VALIDATION_FAILED);
      if (metaInfo != null) {
        override = m_multiSourceHelper.shouldOverride(metaInfo, soureRef);
        metaInfoForChildren = metaInfo;
      } else {
        override = m_multiSourceHelper.shouldOverride(currentParentSourceRef, soureRef);
        metaInfoForChildren = currentParentSourceRef;
      }
    }
    Preconditions.validate(isDiffUpdate || override, ErrorTypePbEnum.VALIDATION_FAILED,
            toPb.getDescriptorForType());
    GeneratedMessageV3 toPbWithoutMeta = null;
    if (metaInfo != null) {
      toPbWithoutMeta = clearMetaInfo(toPb);
      fromPb = clearMetaInfo(fromPb);
    } else {
      toPbWithoutMeta = toPb;
    }

    boolean hasResult = false;
    boolean overridden = false;
    boolean notMatched = false;
    GeneratedMessageV3.Builder builder = (GeneratedMessageV3.Builder) toPbWithoutMeta.toBuilder();
    for (Descriptors.FieldDescriptor fd : toPbWithoutMeta.getDescriptorForType().getFields()) {
      // non - repeated
      if (fd.isOptional() || fd.isRequired()) {
        // message types
        if (fd.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) {
          Pair<GeneratedMessageV3, ProtoMerger.MatchResult> result = merge(
                  (GeneratedMessageV3) toPbWithoutMeta.getField(fd),
                  (GeneratedMessageV3) fromPb.getField(fd), soureRef, matchTime, metaInfoForChildren,
                  isDiffUpdate);
          builder.setField(fd, result.getFirst());
          if (result.getSecond() != MatchResult.CONSUMED) {
            hasResult = true;
          }
          if (result.getSecond() == MatchResult.OVERRIDE) {
            overridden = true;
          }
          if (result.getSecond() == MatchResult.NO_MATCH) {
            notMatched = true;
          }
        } else {
          if ((isDiffUpdate && fd.getDefaultValue().equals(fromPb.getField(fd)))
                  || (!isDiffUpdate && fd.getDefaultValue().equals(fromPb.getField(fd)) && builder
                  .getField(fd).equals(fromPb.getField(fd)))) {
            continue;
          } else {
            hasResult = true;
          }
          if (fd.getDefaultValue().equals(builder.getField(fd))) {
            builder.setField(fd, fromPb.getField(fd));
          } else if (fd.getDefaultValue().equals(fromPb.getField(fd))) {
            // this will come here only in case of !isDiffUpdate
            builder.clearField(fd);
            overridden = true;
          } else if (!builder.getField(fd).equals(fromPb.getField(fd))) {
            if (override) {
              builder.setField(fd, fromPb.getField(fd));
              overridden = true;
            } else {
              notMatched = true;
            }
          }
        }
      } else {
        if (fd.getType() == Descriptors.FieldDescriptor.Type.MESSAGE) {
          List<List<String>> toListIds = getListIds(fd,
                  (List<GeneratedMessageV3>) toPbWithoutMeta.getField(fd));
          List<List<String>> fromListIds = getListIds(fd,
                  (List<GeneratedMessageV3>) fromPb.getField(fd));
          List<List<String>> mergeListIds = null;
          if (isDiffUpdate) {
            mergeListIds = (List<List<String>>) merge(toListIds, fromListIds);
          } else {
            mergeListIds = (List<List<String>>) merge(fromListIds, toListIds);
          }

          List<GeneratedMessageV3> toList = (List<GeneratedMessageV3>) builder.getField(fd);
          builder.clearField(fd);
          for (List<String> id : mergeListIds) {
            if (toListIds.contains(id) && !fromListIds.contains(id)) {
              if (isDiffUpdate) {
                builder.addRepeatedField(fd, toList.get(toListIds.indexOf(id)));
              }
            } else if (!toListIds.contains(id) && fromListIds.contains(id)) {
              Pair<GeneratedMessageV3, ProtoMerger.MatchResult> result = merge(
                      (GeneratedMessageV3) ((GeneratedMessageV3) fromPb.getRepeatedField(fd,
                              fromListIds.indexOf(id))).getDefaultInstanceForType(),
                      (GeneratedMessageV3) fromPb.getRepeatedField(fd, fromListIds.indexOf(id)),
                      soureRef, matchTime, metaInfoForChildren, isDiffUpdate);
              builder.addRepeatedField(fd, result.getFirst());
              if (result.getSecond() != MatchResult.CONSUMED) {
                hasResult = true;
              }
              if (result.getSecond() == MatchResult.OVERRIDE) {
                overridden = true;
              }
              if (result.getSecond() == MatchResult.NO_MATCH) {
                notMatched = true;
              }
            } else {
              Pair<GeneratedMessageV3, ProtoMerger.MatchResult> merged = merge(
                      (GeneratedMessageV3) toPbWithoutMeta
                              .getRepeatedField(fd, toListIds.indexOf(id)),
                      (GeneratedMessageV3) fromPb.getRepeatedField(fd, fromListIds.indexOf(id)),
                      soureRef, matchTime, metaInfoForChildren, isDiffUpdate);
              builder.addRepeatedField(fd, merged.getFirst());
              if (merged.getSecond() != MatchResult.CONSUMED) {
                hasResult = true;
              }
              if (merged.getSecond() == MatchResult.OVERRIDE) {
                overridden = true;
              }
              if (merged.getSecond() == MatchResult.NO_MATCH) {
                notMatched = true;
              }
            }
          }
        } else {
          Preconditions.validate(false, ErrorTypePbEnum.VALIDATION_FAILED,
                  "Repeated non-message types are not supported for merge");
          List<?> mergedData = merge((List) toPbWithoutMeta.getField(fd),
                  (List) fromPb.getField(fd));
          for (int i = toPbWithoutMeta.getRepeatedFieldCount(fd); i < mergedData.size(); ++i) {
            builder.addRepeatedField(fd, mergedData.get(i));
          }
        }
      }
    }
    if (metaInfo != null) {
      MetaInfoPb newMetaInfo = null;
      if (!hasResult) {
        newMetaInfo = metaInfo;
      }
      if (overridden) {
        newMetaInfo = updateMetaInfoOverride(metaInfo, MatchInfoUiEnum.NO_MATCH, soureRef,
                matchTime, -1);
      }
      if (notMatched) {
        newMetaInfo = updateMetaInfoMatch(metaInfo, soureRef, matchTime, MatchInfoUiEnum.NO_MATCH,
                -1);
      } else if (hasResult) {
        newMetaInfo = updateMetaInfoMatch(metaInfo, soureRef, matchTime, MatchInfoUiEnum.MATCH, 0);
      }
      setMetaInfo(builder, newMetaInfo);
      return new Pair<GeneratedMessageV3, ProtoMerger.MatchResult>(
              (GeneratedMessageV3) builder.build(), MatchResult.CONSUMED);
    } else {
      if (!hasResult) {
        return new Pair<GeneratedMessageV3, ProtoMerger.MatchResult>(
                (GeneratedMessageV3) builder.build(), MatchResult.CONSUMED);
      }
      if (overridden) {
        return new Pair<GeneratedMessageV3, ProtoMerger.MatchResult>(
                (GeneratedMessageV3) builder.build(), MatchResult.OVERRIDE);
      }
      if (notMatched) {
        return new Pair<GeneratedMessageV3, MatchResult>(
                (GeneratedMessageV3) builder.build(), MatchResult.NO_MATCH);
      } else {
        return new Pair<GeneratedMessageV3, MatchResult>(
                (GeneratedMessageV3) builder.build(), MatchResult.MATCH);
      }
    }
  }

  private Pair<GeneratedMessageV3, MatchResult> isBasicType(GeneratedMessageV3 toPb,
          GeneratedMessageV3 fromPb, String soureRef, TimePb matchTime,
          MetaInfoPb currentParentSourceRef, boolean isDiffUpdate) throws ErrorException {
    Preconditions.validate(toPb.getDescriptorForType().equals(fromPb.getDescriptorForType()),
            ErrorTypePbEnum.VALIDATION_FAILED, toPb.getDescriptorForType());
    MetaInfoPb metaInfo = m_protoHelper.getFieldByNumber(toPb, 13);
    boolean override = true;
    if (metaInfo != null || currentParentSourceRef != null) {
      Preconditions.validate(Strings.notEmpty(soureRef), ErrorTypePbEnum.VALIDATION_FAILED);
      if (metaInfo != null) {
        override = m_multiSourceHelper.shouldOverride(metaInfo, soureRef);
      } else {
        override = m_multiSourceHelper.shouldOverride(currentParentSourceRef, soureRef);
      }
    }
    Preconditions.validate(isDiffUpdate || override, ErrorTypePbEnum.VALIDATION_FAILED,
            toPb.getDescriptorForType());
    GeneratedMessageV3 toPbWithoutMeta = null;
    if (metaInfo != null) {
      toPbWithoutMeta = clearMetaInfo(toPb);
      fromPb = clearMetaInfo(fromPb);
    } else {
      toPbWithoutMeta = toPb;
    }
    if (!m_checkProtoProperty.isDefaultProto(toPbWithoutMeta)
            && !m_checkProtoProperty.isDefaultProto(fromPb)) {
      Pair<MatchInfoUiEnum, Integer> matchPair = match(toPbWithoutMeta, fromPb);
      MatchInfoUiEnum match = matchPair.getFirst();
      if (match == MatchInfoUiEnum.MATCH) {
        if (metaInfo == null) {
          return new Pair<GeneratedMessageV3, ProtoMerger.MatchResult>(toPbWithoutMeta,
                  MatchResult.MATCH);
        }
        MetaInfoPb newMetaInfo = updateMetaInfoMatch(metaInfo, soureRef, matchTime,
                MatchInfoUiEnum.MATCH, 0);
        return new Pair<GeneratedMessageV3, MatchResult>(setMetaInfo(toPbWithoutMeta,
                newMetaInfo), MatchResult.CONSUMED);
      } else {
        if (override) {
          if (metaInfo == null) {
            return new Pair<GeneratedMessageV3, MatchResult>(fromPb, MatchResult.OVERRIDE);
          }
          MetaInfoPb newMetaInfo = updateMetaInfoOverride(metaInfo, match, soureRef, matchTime,
                  matchPair.getSecond());
          return new Pair<GeneratedMessageV3, MatchResult>(setMetaInfo(fromPb,
                  newMetaInfo), MatchResult.CONSUMED);
        } else {
          if (metaInfo == null) {
            return new Pair<GeneratedMessageV3, MatchResult>(toPbWithoutMeta,
                    MatchResult.NO_MATCH);
          }
          MetaInfoPb newMetaInfo = updateMetaInfoMatch(metaInfo, soureRef, matchTime, match,
                  matchPair.getSecond());
          return new Pair<GeneratedMessageV3, MatchResult>(setMetaInfo(toPbWithoutMeta,
                  newMetaInfo), MatchResult.CONSUMED);
        }
      }
    } else if (m_checkProtoProperty.isDefaultProto(toPbWithoutMeta)
            && !m_checkProtoProperty.isDefaultProto(fromPb)) {
      if (metaInfo == null) {
        return new Pair<GeneratedMessageV3, MatchResult>(fromPb, MatchResult.MATCH);
      }
      MetaInfoPb newMetaInfo = updateMetaInfoMatch(metaInfo, soureRef, matchTime,
              MatchInfoUiEnum.MATCH, 0);
      return new Pair<GeneratedMessageV3, MatchResult>(setMetaInfo(fromPb, newMetaInfo),
              MatchResult.CONSUMED);
    } else {
      if (isDiffUpdate || m_checkProtoProperty.isDefaultProto(toPbWithoutMeta)) {
        return new Pair<GeneratedMessageV3, MatchResult>(toPb, MatchResult.CONSUMED); // no
      }
      if (metaInfo == null) {
        return new Pair<GeneratedMessageV3, MatchResult>(fromPb, MatchResult.OVERRIDE);
      }
      MetaInfoPb newMetaInfo = updateMetaInfoOverride(metaInfo, MatchInfoUiEnum.NO_MATCH, soureRef,
              matchTime, -1);
      return new Pair<GeneratedMessageV3, MatchResult>(setMetaInfo(fromPb, newMetaInfo),
              MatchResult.CONSUMED);
    }
  }

  private Pair<MatchInfoUiEnum, Integer> match(GeneratedMessageV3 first, GeneratedMessageV3 second)
          throws ErrorException {
    String matcherOverride = first.getDescriptorForType().getOptions()
            .getExtension(MergeOption.matcher);
    if (Strings.notEmpty(matcherOverride)) {
      IMatcher matcher = null;
      try {
        Class matcherClass = Class.forName(matcherOverride);
        matcher = (IMatcher) m_injector.getInstance(matcherClass);
      } catch (ClassNotFoundException ex) {
        throw Exceptions.handleThrowable(ex, matcherOverride);
      }
      return matcher.match(first, second);
    }
    if (m_checkProtoProperty.isEqualProtos(first, second)) {
      return new Pair<MatchInfoUiEnum, Integer>(MatchInfoUiEnum.MATCH, 0);
    } else {
      return new Pair<MatchInfoUiEnum, Integer>(MatchInfoUiEnum.NO_MATCH, -1);
    }
  }

  private MetaInfoPb updateMetaInfoOverride(MetaInfoPb metaInfo, MatchInfoUiEnum matchWithOldValue,
          String soureRef, TimePb matchTime, int diff) {
    MetaInfoPb.Builder updatedMet = MetaInfoPb.newBuilder(metaInfo);
    for (MatchInfoPb.Builder machInfo : updatedMet.getMatchInfoBuilderList()) {
      if (matchWithOldValue == MatchInfoUiEnum.NO_MATCH) {
        if (machInfo.getMatchInfo() == MatchInfoUiEnum.MATCH
                || machInfo.getMatchInfo() == MatchInfoUiEnum.APPROX_MATCH) {
          machInfo.setMatchInfo(MatchInfoUiEnum.NO_MATCH);
          if (machInfo.getMatchInfo() == MatchInfoUiEnum.APPROX_MATCH) {
            machInfo.clearDiff();
          }
        } else if (machInfo.getMatchInfo() == MatchInfoUiEnum.NO_MATCH) {
          machInfo.setMatchInfo(MatchInfoUiEnum.UNKNOWN_INFO);
        }
      } else if (matchWithOldValue == MatchInfoUiEnum.APPROX_MATCH) {
        if (machInfo.getMatchInfo() == MatchInfoUiEnum.MATCH) {
          machInfo.setMatchInfo(MatchInfoUiEnum.APPROX_MATCH);
          machInfo.setDiff(diff);
        }
      }
    }
    updateMetaInfoMatch(updatedMet, soureRef, matchTime, MatchInfoUiEnum.MATCH, 0);
    return updatedMet.build();
  }

  private MetaInfoPb updateMetaInfoMatch(MetaInfoPb metaInfo, String soureRef, TimePb matchTime,
          MatchInfoUiEnum match, Integer diff) {
    MetaInfoPb.Builder updatedMet = MetaInfoPb.newBuilder(metaInfo);
    updateMetaInfoMatch(updatedMet, soureRef, matchTime, match, diff);
    return updatedMet.build();
  }

  private void updateMetaInfoMatch(MetaInfoPb.Builder metaInfo, String soureRef, TimePb matchTime,
          MatchInfoUiEnum match, Integer diff) {
    boolean foundSourceRef = false;
    for (MatchInfoPb.Builder machInfo : metaInfo.getMatchInfoBuilderList()) {
      if (machInfo.getSourceRefId().equals(soureRef)) {
        foundSourceRef = true;
        machInfo.setMatchedTime(matchTime);
        machInfo.setMatchInfo(match);
        if (match == MatchInfoUiEnum.APPROX_MATCH) {
          machInfo.setDiff(diff);
        } else {
          machInfo.clearDiff();
        }
      }
    }
    if (!foundSourceRef) {
      MatchInfoPb.Builder add = metaInfo.addMatchInfoBuilder();
      add.setSourceRefId(soureRef);
      add.setMatchedTime(matchTime);
      add.setMatchInfo(match);
      if (match == MatchInfoUiEnum.APPROX_MATCH) {
        add.setDiff(diff);
      } else {
        add.clearDiff();
      }
    }
  }

  private GeneratedMessageV3 setMetaInfo(GeneratedMessageV3 message, MetaInfoPb metaInfo) {
    GeneratedMessageV3.Builder builder = (GeneratedMessageV3.Builder) message.toBuilder();
    setMetaInfo(builder, metaInfo);
    return (GeneratedMessageV3) builder.build();
  }

  private void setMetaInfo(GeneratedMessageV3.Builder message, MetaInfoPb metaInfo) {
    message.setField(message.getDescriptorForType().findFieldByNumber(13), metaInfo);
  }

  private GeneratedMessageV3 clearMetaInfo(GeneratedMessageV3 message) {
    GeneratedMessageV3.Builder builder = (GeneratedMessageV3.Builder) message.toBuilder();
    builder.clearField(message.getDescriptorForType().findFieldByNumber(13));
    return (GeneratedMessageV3) builder.build();
  }

  private List<List<String>> getListIds(Descriptors.FieldDescriptor fd, List<GeneratedMessageV3> repeatedMessage) {
    List<List<Integer>> idPath = getMergeIdFields(fd);
    List<List<String>> ids = Lists.newArrayList();
    Set<List<String>> idSet = Sets.newHashSet();
    for (int index = 0; index < repeatedMessage.size(); index++) {
      List<String> id = m_mergerHelper.getMergerTokenSet(repeatedMessage.get(index), index, idPath);
      ids.add(id);
      idSet.add(id);
    }
    Preconditions.validate(ids.size() == idSet.size(), "Repeated data has duplicate merge tokens",
            ids);
    return ids;
  }

  private List<?> merge(List<?> toIdList, List<?> fromIdList) {
    List merged = Lists.newArrayList(toIdList);
    for (Object o : fromIdList) {
      if (!toIdList.contains(o)) {
        merged.add(o);
      }
    }
    return merged;
  }

  private List<List<Integer>> getMergeIdFields(Descriptors.FieldDescriptor fd) {
    String messageOptionValue = fd.getMessageType().getOptions()
            .getExtension(MergeOption.mergeToken);
    List<String> stringListPath = Arrays.asList(messageOptionValue.split(","));

    return m_mergerHelper.getListOfIntTokenPath(stringListPath);
  }
}

