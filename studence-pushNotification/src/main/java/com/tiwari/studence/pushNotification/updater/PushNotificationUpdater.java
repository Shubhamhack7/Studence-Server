package com.tiwari.studence.pushNotification.updater;

import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationPb;
import com.tiwari.studence.pushNotification.indexer.PushNotificationIndexer;
import com.tiwari.studence.pushNotification.provider.PushNotificationProvider;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.helper.GenericRefHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import java.util.HashMap;

public class PushNotificationUpdater extends AEntityUpdater<PushNotificationPb,PushNotificationPb.Builder, PushNotificationProvider, PushNotificationIndexer> {

  private GenericRefHelper m_genericRefHelper;
  @Inject
  public PushNotificationUpdater(PushNotificationIndexer indexer,
          PushNotificationProvider builderProvider,GenericRefHelper genericRefHelper) {
    super(indexer, builderProvider);
    m_genericRefHelper=genericRefHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(PushNotificationPb builder, EntityPb pb) {
    PushNotificationPb.Builder orgBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(orgBuilder.getDbInfoBuilder(), pb);
    if(Strings.notEmpty(builder.getToken())){
      orgBuilder.setToken(builder.getToken());
    }
    m_genericRefHelper.updateGenricRefHelper(orgBuilder.getOrgRefBuilder(),builder.getOrgRef());
    m_genericRefHelper.updateGenricRefHelper(orgBuilder.getCampusRefBuilder(),builder.getCampusRef());
    m_genericRefHelper.updateGenricRefHelper(orgBuilder.getDeviceRefBuilder(),builder.getDeviceRef());
    m_genericRefHelper.updateGenricRefHelper(orgBuilder.getLoginRefBuilder(),builder.getLoginRef());
    return super.updater(builder);
  }
}
