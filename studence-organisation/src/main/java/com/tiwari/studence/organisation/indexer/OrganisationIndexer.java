package com.tiwari.studence.organisation.indexer;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue.Type;

@Singleton
public class OrganisationIndexer extends AEntityIndexer<OrganisationPb> {

  @Inject
  public OrganisationIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(OrganisationPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, OrganisationIndexerEnum.NAME.name(), builder.getName().toLowerCase(), false,
            Type.S);
    return items;
  }

}
