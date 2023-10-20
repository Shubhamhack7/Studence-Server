package com.tiwari.studence.pushNotification.service;

import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.proto.pushNotification.PushNotificationPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchReqPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchRespPb;

public interface IPushNotificationService extends
        IEntityService<PushNotificationPb, PushNotificationSearchReqPb, PushNotificationSearchRespPb> {
}
