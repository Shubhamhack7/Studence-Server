package com.tiwari.studence.organisation.indexer;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.tiwari.studence.common.service.v1.indexer.AEntityIndexer;
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
    addItemToAttritibeMap(items, OrganisationIndexerEnum.ORGANISATION_NAME.getLabel(), builder.getName().getCanonicalName(), false,
            Type.S, OrganisationIndexerEnum.ORGANISATION_NAME.isLowerCase());
    addItemToAttritibeMap(items, OrganisationIndexerEnum.ORGANISATION_EMAIL.name(), builder.getContactDetails().getEmails().getPrimary().getCanonicalEmail(), false,
            Type.S, OrganisationIndexerEnum.ORGANISATION_EMAIL.isLowerCase());
    addItemToAttritibeMap(items, OrganisationIndexerEnum.ORGANISATION_MOBILE_NUMBER.name(), builder.getContactDetails().getMobileNumbers().getPrimary().getCanonicalNumber(), false,
            Type.S, OrganisationIndexerEnum.ORGANISATION_MOBILE_NUMBER.isLowerCase());
    addItemToAttritibeMap(items, OrganisationIndexerEnum.ORGANISATION_ADDRESS.name(), builder.getContactDetails().getAddress().getPrimary().getCanonicalAddress(), false,
            Type.S, OrganisationIndexerEnum.ORGANISATION_ADDRESS.isLowerCase());
    return items;
  }

}
