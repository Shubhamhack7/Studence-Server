package com.tiwari.studence.pushNotification.provider;

import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchReqPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchRespPb;

import javax.inject.Inject;

public class PushNotificationSearchPbProvider implements
        IReqRespPbBuilderProvider<PushNotificationSearchReqPb, PushNotificationSearchReqPb.Builder, PushNotificationSearchRespPb, PushNotificationSearchRespPb.Builder> {

  @Inject
  PushNotificationSearchPbProvider() {

  }

  @Override
  public PushNotificationSearchReqPb.Builder getReqBuilder() {
    return PushNotificationSearchReqPb.newBuilder();
  }

  @Override
  public PushNotificationSearchReqPb.Builder getReqBuilder(PushNotificationSearchReqPb builder) {
    return PushNotificationSearchReqPb.newBuilder(builder);
  }

  @Override
  public PushNotificationSearchRespPb.Builder getRespBuilder() {
    return PushNotificationSearchRespPb.newBuilder();
  }

  @Override
  public PushNotificationSearchRespPb.Builder getRespBuilder(PushNotificationSearchRespPb builder) {
    return PushNotificationSearchRespPb.newBuilder(builder);
  }
}
