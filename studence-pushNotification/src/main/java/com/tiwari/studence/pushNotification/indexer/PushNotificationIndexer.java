package com.tiwari.studence.pushNotification.indexer;

import com.tiwari.studence.common.service.v1.indexer.AEntityIndexer;
import com.tiwari.studence.proto.pushNotification.PushNotificationPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class PushNotificationIndexer extends AEntityIndexer<PushNotificationPb> {

  @Inject
  public PushNotificationIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(PushNotificationPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, PushNotificationIndexerEnum.PUSH_NOTIFICATION_TOKEN.getLabel(),
            builder.getToken(), false, AttributeValue.Type.S,
            PushNotificationIndexerEnum.PUSH_NOTIFICATION_TOKEN.isLowerCase());
    addItemToAttritibeMap(items, PushNotificationIndexerEnum.PUSH_NOTIFICATION_ORGANISATION_REF_ID.getLabel(),
            builder.getOrgRef().getDbInfoId(), false, AttributeValue.Type.S,
            PushNotificationIndexerEnum.PUSH_NOTIFICATION_ORGANISATION_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, PushNotificationIndexerEnum.PUSH_NOTIFICATION_ORGANISATION_REF_NAME.getLabel(),
            builder.getOrgRef().getDbInfoId(), false, AttributeValue.Type.S,
            PushNotificationIndexerEnum.PUSH_NOTIFICATION_ORGANISATION_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, PushNotificationIndexerEnum.PUSH_NOTIFICATION_CAMPUS_REF_ID.getLabel(),
            builder.getOrgRef().getDbInfoId(), false, AttributeValue.Type.S,
            PushNotificationIndexerEnum.PUSH_NOTIFICATION_CAMPUS_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, PushNotificationIndexerEnum.PUSH_NOTIFICATION_CAMPUS_REF_NAME.getLabel(),
            builder.getOrgRef().getDbInfoId(), false, AttributeValue.Type.S,
            PushNotificationIndexerEnum.PUSH_NOTIFICATION_CAMPUS_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, PushNotificationIndexerEnum.PUSH_NOTIFICATION_DEVICE_REF_ID.getLabel(),
            builder.getOrgRef().getDbInfoId(), false, AttributeValue.Type.S,
            PushNotificationIndexerEnum.PUSH_NOTIFICATION_DEVICE_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, PushNotificationIndexerEnum.PUSH_NOTIFICATION_DEVICE_REF_NAME.getLabel(),
            builder.getOrgRef().getDbInfoId(), false, AttributeValue.Type.S,
            PushNotificationIndexerEnum.PUSH_NOTIFICATION_DEVICE_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, PushNotificationIndexerEnum.PUSH_NOTIFICATION_LOGIN_REF_ID.getLabel(),
            builder.getOrgRef().getDbInfoId(), false, AttributeValue.Type.S,
            PushNotificationIndexerEnum.PUSH_NOTIFICATION_LOGIN_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, PushNotificationIndexerEnum.PUSH_NOTIFICATION_LOGIN_REF_NAME.getLabel(),
            builder.getOrgRef().getDbInfoId(), false, AttributeValue.Type.S,
            PushNotificationIndexerEnum.PUSH_NOTIFICATION_LOGIN_REF_NAME.isLowerCase());
    return items;
  }
}
