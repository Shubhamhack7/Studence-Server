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
    addItemToAttritibeMap(items, OrganisationIndexerEnum.ORGANISATION_NAME.name(), builder.getName().getCanonicalName().toLowerCase(), false,
            Type.S);
    addItemToAttritibeMap(items, OrganisationIndexerEnum.ORGANISATION_EMAIL.name(), builder.getContactDetails().getEmails().getPrimary().getCanonicalEmail().toLowerCase(), false,
            Type.S);
    addItemToAttritibeMap(items, OrganisationIndexerEnum.ORGANISATION_MOBILE_NUMBER.name(), builder.getContactDetails().getMobileNumbers().getPrimary().getCanonicalNumber().toLowerCase(), false,
            Type.S);
    addItemToAttritibeMap(items, OrganisationIndexerEnum.ORGANISATION_ADDRESS.name(), builder.getContactDetails().getAddress().getPrimary().getCanonicalAddress().toLowerCase(), false,
            Type.S);
    return items;
  }

}
