package com.tiwari.studence.common.indexer;

import java.util.HashMap;

import javax.inject.Inject;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import com.tiwari.studence.util.protobuf.ProtobufToJson;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue.Type;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public abstract class AEntityIndexer<P extends GeneratedMessageV3> implements IIndexer<P> {

  public enum GenericIndexerEnum {
    ID,
    RANGE,
    LIFETIME,
    VERSION,
    RAW_DATA

  }

  private JsonBaseEncoderDecoder m_jsonBaseEncoderDecoder;

  @Inject
  public AEntityIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    m_jsonBaseEncoderDecoder = jsonBaseEncoderDecoder;
  }

  @Override
  public HashMap<String, AttributeValue> indexer(P builder) {
    HashMap<String, AttributeValue> itemValues = new HashMap<>();
    itemValues.put(GenericIndexerEnum.RAW_DATA.name(), AttributeValue.builder()
            .s(m_jsonBaseEncoderDecoder.convert(ProtobufToJson.protobufToJsonString(builder)))
            .build());
    return itemValues;
  }

  public HashMap<String, AttributeValue> getGenricEntityIndexer(
          HashMap<String, AttributeValue> item, EntityPb pb) {
    item.put(GenericIndexerEnum.ID.name(), AttributeValue.builder().s(pb.getHashId()).build());
    item.put(GenericIndexerEnum.RANGE.name(), AttributeValue.builder().s(pb.getRangeId()).build());
    item.put(GenericIndexerEnum.LIFETIME.name(),
            AttributeValue.builder().s(pb.getLifetime().name()).build());
    item.put(GenericIndexerEnum.VERSION.name(),
            AttributeValue.builder().s(String.valueOf(pb.getConfig().getVersion())).build());
    return item;
  }

  public void addItemToAttritibeMap(HashMap<String, AttributeValue> item, String key, String value,
          boolean bool_val, Type type, boolean lowerCase) {
    if (type == Type.S && lowerCase) {
      item.put(key, AttributeValue.builder().s(Strings.getLowerCaseList(value)).build());
    } else if (type == Type.S) {
      item.put(key, AttributeValue.builder().s(value).build());
    }  else if (type == Type.N) {
      item.put(key, AttributeValue.builder().n(value).build());
    } else if (type == Type.B) {
      item.put(key, AttributeValue.builder().bool(bool_val).build());
    } else {
      // nothing
    }
  }

}
