package com.tiwari.studence.common.service.v2.helper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.tiwari.studence.common.encoders.Base64PbDecoder;
import com.tiwari.studence.common.service.v2.index.EntityIndexAttributes;
import com.tiwari.studence.common.service.v2.interfaces.ISecondaryIndexEntity;
import com.tiwari.studence.common.util.GNormalizedProto;
import com.tiwari.studence.common.util.RangeHashKeyConcatinator;
import com.tiwari.studence.proto.search.PaginationTokenUiPb;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.common.StudenceSpecialCharecterEnum;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;

@Singleton
public class DynamoDbNextTokenWithTablePartitionHelper {
  private final GNormalizedProto m_gNormalizedProto;
  private final Base64PbDecoder<PaginationTokenUiPb, PaginationTokenUiPb.Builder> m_encoder;
  private final RangeHashKeyConcatinator m_split;

  @Inject
  public DynamoDbNextTokenWithTablePartitionHelper(GNormalizedProto gNormalizedProto,
          Base64PbDecoder<PaginationTokenUiPb, PaginationTokenUiPb.Builder> encoder,
          RangeHashKeyConcatinator split) {
    m_gNormalizedProto = gNormalizedProto;
    m_encoder = encoder;
    m_split = split;
  }

  public Map<String, AttributeValue> getStartKey(ISecondaryIndexEntity secondaryIndexEntity,
          String startToken) {
    PaginationTokenUiPb token = m_encoder.convert(startToken);
    if (token == null) {
      return null;
    }
    Map<String, AttributeValue> map = Maps.newHashMap();
    String keyOne = token.getKeyOne();
    if (keyOne.contains(StudenceSpecialCharecterEnum.EXCLAMATION.getSign())) {
      Pair<String, String> key = m_split.splitHashRangeKeys(keyOne);
      map.put(EntityIndexAttributes.ITEM_ID.name(), new AttributeValue().withS(key.getFirst()));
      map.put(EntityIndexAttributes.RANGE_KEY.name(), new AttributeValue().withS(key.getSecond()));
    } else {
      map.put(EntityIndexAttributes.ITEM_ID.name(), new AttributeValue().withS(keyOne));
    }
    if (secondaryIndexEntity != null && Strings.notEmpty(secondaryIndexEntity.getEntityFullName())) {
      String keyTwo = token.getKeyTwo();
      if (keyTwo.contains(StudenceSpecialCharecterEnum.EXCLAMATION.getSign())) {
        Pair<String, String> key = m_split.splitHashRangeKeys(keyTwo);
        map.put(secondaryIndexEntity.getItemIdName(), new AttributeValue().withS(key.getFirst()));
        map.put(secondaryIndexEntity.getRangeKeyName(), new AttributeValue().withS(key.getSecond()));
      } else {
        map.put(secondaryIndexEntity.getItemIdName(), new AttributeValue().withS(keyTwo));
      }
    }
    return map;
  }

  public String getNextToken(ISecondaryIndexEntity secondaryIndexEntity,
          Map<String, AttributeValue> lastEvaluatedKey) {
    PaginationTokenUiPb.Builder builder = PaginationTokenUiPb.newBuilder();
    if (lastEvaluatedKey != null) {
      String hashKey = lastEvaluatedKey.get(EntityIndexAttributes.ITEM_ID.name()).getS();
      String rangeKey = "";
      if (lastEvaluatedKey.containsKey(EntityIndexAttributes.RANGE_KEY.name())) {
        rangeKey = lastEvaluatedKey.get(EntityIndexAttributes.RANGE_KEY.name()).getS();
      }
      if (Strings.notEmpty(hashKey) && Strings.notEmpty(rangeKey)) {
        builder.setKeyOne(m_split.joinHashRangeKeys(hashKey, rangeKey));
      } else {
        builder.setKeyOne(hashKey);
      }
      if (secondaryIndexEntity != null && Strings.notEmpty(secondaryIndexEntity.getEntityFullName())) {
        String indexHashKey = lastEvaluatedKey.get(secondaryIndexEntity.getItemIdName()).getS();
        String indexRangeKey = "";
        if (lastEvaluatedKey.containsKey(secondaryIndexEntity.getRangeKeyName())) {
          indexRangeKey = lastEvaluatedKey.get(secondaryIndexEntity.getRangeKeyName()).getS();
        }
        if (Strings.notEmpty(indexRangeKey)) {
          builder.setKeyTwo(m_split.joinHashRangeKeys(indexHashKey, indexRangeKey));
        } else {
          builder.setKeyTwo(indexHashKey);
        }
      }
    }
    if (m_gNormalizedProto.isDefaultProto(builder.build())) {
      return "";
    }
    return m_encoder.reverseConvert(builder.build());
  }

}

