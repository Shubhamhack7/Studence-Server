package com.tiwari.studence.util.helper;

import com.tiwari.studence.proto.pushNotification.PushNotificationRefPb;
import com.tiwari.studence.util.common.Strings;

import javax.inject.Inject;

public class PushNotificationHelper {

  @Inject
  PushNotificationHelper(){

  }

  public void updatePushNotificationRef(PushNotificationRefPb.Builder pushNotificationRefBuilder, PushNotificationRefPb pushNotificationRef) {
    if(Strings.notEmpty(pushNotificationRef.getDbInfoId())){
      pushNotificationRefBuilder.setDbInfoId(pushNotificationRef.getDbInfoId());
    }
    if(Strings.notEmpty(pushNotificationRef.getToken())){
      pushNotificationRefBuilder.setToken(pushNotificationRef.getToken());
    }
  }
}
