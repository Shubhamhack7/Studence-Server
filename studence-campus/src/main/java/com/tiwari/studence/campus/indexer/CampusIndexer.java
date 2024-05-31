package com.tiwari.studence.campus.indexer;

import com.tiwari.studence.common.service.v1.indexer.AEntityIndexer;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class CampusIndexer extends AEntityIndexer<CampusPb> {
  @Inject
  public CampusIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(CampusPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, CampusIndexerEnum.CAMPUS_NAME.name(),
            builder.getName().getCanonicalName(), false, AttributeValue.Type.S,
            CampusIndexerEnum.CAMPUS_NAME.isLowerCase());
    addItemToAttritibeMap(items, CampusIndexerEnum.CAMPUS_MOBILE.name(),
            builder.getContactDetails().getMobileNumbers().getPrimary().getCanonicalNumber()
                    .toLowerCase(), false, AttributeValue.Type.S,
            CampusIndexerEnum.CAMPUS_MOBILE.isLowerCase());
    addItemToAttritibeMap(items, CampusIndexerEnum.CAMPUS_EMAIL.name(),
            builder.getContactDetails().getEmails().getPrimary().getCanonicalEmail().toLowerCase(),
            false, AttributeValue.Type.S, CampusIndexerEnum.CAMPUS_EMAIL.isLowerCase());
    addItemToAttritibeMap(items, CampusIndexerEnum.CAMPUS_ADDRESS.name(),
            builder.getContactDetails().getAddress().getPrimary().getCanonicalAddress()
                    .toLowerCase(), false, AttributeValue.Type.S,
            CampusIndexerEnum.CAMPUS_ADDRESS.isLowerCase());
    addItemToAttritibeMap(items, CampusIndexerEnum.CAMPUS_ORG_REF_ID.name(),
            builder.getOrganisationRef().getDbInfoId(), false, AttributeValue.Type.S,
            CampusIndexerEnum.CAMPUS_ORG_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, CampusIndexerEnum.CAMPUS_ORG_REF_NAME.name(),
            builder.getOrganisationRef().getName().toLowerCase(), false, AttributeValue.Type.S,
            CampusIndexerEnum.CAMPUS_ORG_REF_NAME.isLowerCase());
    return items;
  }
}
