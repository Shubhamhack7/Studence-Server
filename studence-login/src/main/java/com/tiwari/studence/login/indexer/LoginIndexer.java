package com.tiwari.studence.login.indexer;

import com.tiwari.studence.common.service.v1.indexer.AEntityIndexer;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class LoginIndexer extends AEntityIndexer<LoginPb> {

  @Inject
  public LoginIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(LoginPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_REF_ID.getLabel(),
            builder.getRef().getDbInfoId(), false, AttributeValue.Type.S,
            LoginIndexerEnum.LOGIN_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_TYPE.getLabel(),
            builder.getType().name(), false, AttributeValue.Type.S,
            LoginIndexerEnum.LOGIN_TYPE.isLowerCase());
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_REF_NAME.name(),
            builder.getRef().getName(), false, AttributeValue.Type.S,
            LoginIndexerEnum.LOGIN_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_MOBILE_NO.name(),
            builder.getMobileNo().getCanonicalNumber(), false, AttributeValue.Type.S,
            LoginIndexerEnum.LOGIN_MOBILE_NO.isLowerCase());
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_EMAIL_ID.name(),
            builder.getEmailId().getCanonicalEmail(), false, AttributeValue.Type.S,
            LoginIndexerEnum.LOGIN_EMAIL_ID.isLowerCase());
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_FIREBASE_TOKEN.name(),
            builder.getFirebaseToken(), false, AttributeValue.Type.S,
            LoginIndexerEnum.LOGIN_FIREBASE_TOKEN.isLowerCase());
    return items;
  }
}
