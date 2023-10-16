package com.tiwari.studence.common.convertor;

import java.util.HashMap;

import javax.inject.Inject;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.indexer.AEntityIndexer.GenericIndexerEnum;
import com.tiwari.studence.common.prtovider.IPbBuilderProvider;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import com.tiwari.studence.util.protobuf.ProtobufToJson;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public abstract class AEntityConvertor<P extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P,BU>>
        implements IConvertor<P> {

  private JsonBaseEncoderDecoder m_jsonBaseEncoderDecoder;
  private BP m_buildertprovider;

  @Inject
  public AEntityConvertor(BP builderProvider, JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    m_jsonBaseEncoderDecoder = jsonBaseEncoderDecoder;
    m_buildertprovider = builderProvider;
  }

  @Override
  public P convert(HashMap<String, AttributeValue> map) {
    AttributeValue attributejson = map.get(GenericIndexerEnum.RAW_DATA.name());
    BU builder = m_buildertprovider.getBuilder();
    P protObj = (P) ProtobufToJson.jsonStringToProtobuf(
            m_jsonBaseEncoderDecoder.reverseConvert(attributejson.s()), builder);
    return protObj;
  }

}
