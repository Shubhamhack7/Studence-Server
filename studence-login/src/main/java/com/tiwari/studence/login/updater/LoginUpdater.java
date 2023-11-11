package com.tiwari.studence.login.updater;

import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.login.indexer.LoginIndexer;
import com.tiwari.studence.login.provider.LoginPbProvider;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.proto.login.ProfileTypeEnum;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.encoder.PasswordEncryptor;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.GenericRefHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class LoginUpdater
        extends AEntityUpdater<LoginPb, LoginPb.Builder, LoginPbProvider, LoginIndexer> {

  private GenericRefHelper m_genericRefHelper;
  private ContactDetailsHelper m_contactDetailsHelper;

  @Inject
  public LoginUpdater(LoginIndexer indexer, LoginPbProvider builderProvider,
          GenericRefHelper genericRefHelper, ContactDetailsHelper contactDetailsHelper) {
    super(indexer, builderProvider);
    m_genericRefHelper = genericRefHelper;
    m_contactDetailsHelper = contactDetailsHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(LoginPb builder, EntityPb pb) {
    LoginPb.Builder loginBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(loginBuilder.getDbInfoBuilder(), pb);
    if (builder.getType() != ProfileTypeEnum.UNKNOWN_LOGIN_TYPE) {
      loginBuilder.setType(builder.getType());
    }
    if (Strings.notEmpty(builder.getRef().getDbInfoId())) {
      m_genericRefHelper.updateGenricRefHelper(loginBuilder.getRefBuilder(), builder.getRef());
    }
    if (Strings.notEmpty(builder.getEmailId().getLocalPart()) && Strings.notEmpty(
            builder.getEmailId().getDomainPart())) {
      m_contactDetailsHelper.updateEmail(builder.getEmailId(), loginBuilder.getEmailIdBuilder());
    }
    if (Strings.notEmpty(builder.getMobileNo().getNumber())) {
      m_contactDetailsHelper.updateMobile(builder.getMobileNo(), loginBuilder.getMobileNoBuilder());
    }
    if (Strings.notEmpty(builder.getEncryptedPassword())) {
      loginBuilder.setEncryptedPassword(
              PasswordEncryptor.encryptPassword(builder.getEncryptedPassword()));
    }
    if (Strings.notEmpty(builder.getFirebaseToken())) {
      loginBuilder.setFirebaseToken(builder.getFirebaseToken());
    }
    return super.updater(loginBuilder.build());
  }
}
