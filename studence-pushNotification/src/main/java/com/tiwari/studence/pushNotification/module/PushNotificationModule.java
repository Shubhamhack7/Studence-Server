package com.tiwari.studence.pushNotification.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.pushNotification.service.IPushNotificationService;
import com.tiwari.studence.pushNotification.service.PushNotificationService;

import javax.inject.Singleton;

public class PushNotificationModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IPushNotificationService.class).to(PushNotificationService.class);
  }
}
