package com.tiwari.studence.pushNotification.provider;

import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.proto.pushNotification.PushNotificationPb;

import javax.inject.Inject;

public class PushNotificationProvider
        implements IPbBuilderProvider<PushNotificationPb, PushNotificationPb.Builder> {

  @Inject
  PushNotificationProvider() {

  }

  @Override
  public PushNotificationPb.Builder getBuilder() {
    return PushNotificationPb.newBuilder();
  }

  @Override
  public PushNotificationPb.Builder getBuilder(PushNotificationPb builder) {
    return PushNotificationPb.newBuilder(builder);
  }
}
