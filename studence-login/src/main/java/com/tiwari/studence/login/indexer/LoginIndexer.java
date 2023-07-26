package com.tiwari.studence.login.indexer;

import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class LoginIndexer extends AEntityIndexer<LoginPb> {

  public LoginIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(LoginPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_REF_ID.name(), builder.getRef().getDbInfoId(), false,
            AttributeValue.Type.S);
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_REF_NAME.name(), builder.getRef().getName().toLowerCase(), false,
            AttributeValue.Type.S);
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_MOBILE_NO.name(), builder.getMobileNo().getCanonicalNumber().toLowerCase(), false,
            AttributeValue.Type.S);
    addItemToAttritibeMap(items, LoginIndexerEnum.LOGIN_EMAIL_ID.name(), builder.getEmailId().getCanonicalEmail().toLowerCase(), false,
            AttributeValue.Type.S);
    return items;
  }
}
