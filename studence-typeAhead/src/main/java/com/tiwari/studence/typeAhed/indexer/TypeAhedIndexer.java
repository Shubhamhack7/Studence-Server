package com.tiwari.studence.typeAhed.indexer;

import com.tiwari.studence.common.service.v1.indexer.AEntityIndexer;
import com.tiwari.studence.proto.typeAhead.TypeAheadPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class TypeAhedIndexer extends AEntityIndexer<TypeAheadPb> {

  @Inject
  public TypeAhedIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(TypeAheadPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, TypeAheadIndexerEnum.TYPE_AHEAD_CONTEXT_ID.getLabel(),
            builder.getContext().getDbInfoId(), false, AttributeValue.Type.S,
            TypeAheadIndexerEnum.TYPE_AHEAD_CONTEXT_ID.isLowerCase());
    addItemToAttritibeMap(items, TypeAheadIndexerEnum.TYPE_AHEAD_CONTEXT_NAME.getLabel(),
            builder.getContext().getName(), false, AttributeValue.Type.S,
            TypeAheadIndexerEnum.TYPE_AHEAD_CONTEXT_NAME.isLowerCase());
    addItemToAttritibeMap(items, TypeAheadIndexerEnum.TYPE_AHEAD_TYPE.getLabel(),
            builder.getTypeAheadType().name(), false, AttributeValue.Type.S,
            TypeAheadIndexerEnum.TYPE_AHEAD_TYPE.isLowerCase());
    return items;
  }
}
