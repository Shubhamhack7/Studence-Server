package com.tiwari.studence.common.convertor;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.indexer.AEntityIndexer.GenericIndexerEnum;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.summary.SummaryPb;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import com.tiwari.studence.util.protobuf.ProtobufToJson;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public abstract class AEntityConvertor<P extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P, BU>, Lreq extends GeneratedMessageV3, LreqBU extends GeneratedMessageV3.Builder,Lresp extends GeneratedMessageV3, RBU extends GeneratedMessageV3.Builder, RBUP extends IReqRespPbBuilderProvider<Lreq,LreqBU,Lresp, RBU>>
        implements IConvertor<P,Lresp> {

  private JsonBaseEncoderDecoder m_jsonBaseEncoderDecoder;
  private BP m_buildertprovider;

  private RBUP m_respProvider;

  @Inject
  public AEntityConvertor(BP builderProvider, JsonBaseEncoderDecoder jsonBaseEncoderDecoder,RBUP respProvider) {
    m_jsonBaseEncoderDecoder = jsonBaseEncoderDecoder;
    m_buildertprovider = builderProvider;
    m_respProvider = respProvider;
  }

  @Override
  public P convert(HashMap<String, AttributeValue> map) {
    AttributeValue attributejson = map.get(GenericIndexerEnum.RAW_DATA.name());
    BU builder = m_buildertprovider.getBuilder();
    P protObj = (P) ProtobufToJson.jsonStringToProtobuf(
            m_jsonBaseEncoderDecoder.reverseConvert(attributejson.s()), builder);
    return protObj;
  }

  public Lresp searchRespConvert(List<HashMap<String, AttributeValue>> listmap) {
    RBU resp = m_respProvider.getRespBuilder();
    Descriptors.FieldDescriptor summaryDesc=resp.getDescriptorForType().findFieldByNumber(1);
    Descriptors.FieldDescriptor respDesc = resp.getDescriptorForType().findFieldByNumber(2);
    DynamicMessage.Builder dynamicMessageBuilder = DynamicMessage.newBuilder(resp.getDescriptorForType());
    SummaryPb.Builder summaryPb = SummaryPb.newBuilder();
    summaryPb.setResultsCount(listmap.size());
    dynamicMessageBuilder.setField(summaryDesc, summaryPb.build());
    List<P> m_responseList = Lists.newArrayList();
    listmap.forEach(list1->{
      AttributeValue attributejson = list1.get(GenericIndexerEnum.RAW_DATA.name());
      BU builder = m_buildertprovider.getBuilder();
      P protObj = (P) ProtobufToJson.jsonStringToProtobuf(
              m_jsonBaseEncoderDecoder.reverseConvert(attributejson.s()), builder);
      dynamicMessageBuilder.addRepeatedField(respDesc,protObj);
      m_responseList.add(protObj);
    });

    resp.mergeFrom(dynamicMessageBuilder.build());
    return (Lresp) resp.build();
  }

}
