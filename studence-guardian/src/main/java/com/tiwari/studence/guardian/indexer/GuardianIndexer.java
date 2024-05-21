package com.tiwari.studence.guardian.indexer;

import com.tiwari.studence.common.service.v1.indexer.AEntityIndexer;
import com.tiwari.studence.proto.guardian.GuardianPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GuardianIndexer extends AEntityIndexer<GuardianPb> {

  @Inject
  public GuardianIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(GuardianPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, GuardianIndexerEnum.GUARDIAN_FATHER_NAME.getLabel(),
            builder.getFatherName().getCanonicalName(), false, AttributeValue.Type.S,
            GuardianIndexerEnum.GUARDIAN_FATHER_NAME.isLowerCase());
    addItemToAttritibeMap(items, GuardianIndexerEnum.GUARDIAN_MOTHER_NAME.name(),
            builder.getMotherName().getCanonicalName(), false, AttributeValue.Type.S,
            GuardianIndexerEnum.GUARDIAN_MOTHER_NAME.isLowerCase());
    addItemToAttritibeMap(items, GuardianIndexerEnum.GUARDIAN_EMAIL.name(),
            builder.getContactDetails().getEmails().getPrimary().getCanonicalEmail(), false,
            AttributeValue.Type.S, GuardianIndexerEnum.GUARDIAN_EMAIL.isLowerCase());
    addItemToAttritibeMap(items, GuardianIndexerEnum.GUARDIAN_MOBILE_NUMBER.name(),
            builder.getContactDetails().getMobileNumbers().getPrimary().getCanonicalNumber(), false,
            AttributeValue.Type.S, GuardianIndexerEnum.GUARDIAN_MOBILE_NUMBER.isLowerCase());
    addItemToAttritibeMap(items, GuardianIndexerEnum.GUARDIAN_ADDRESS.name(),
            builder.getContactDetails().getAddress().getPrimary().getCanonicalAddress(), false,
            AttributeValue.Type.S, GuardianIndexerEnum.GUARDIAN_ADDRESS.isLowerCase());
    return items;
  }
}
