package com.tiwari.studence.pushNotification.convertor;

import com.tiwari.studence.common.convertor.AEntityConvertor;
import com.tiwari.studence.proto.pushNotification.PushNotificationPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchReqPb;
import com.tiwari.studence.proto.pushNotification.PushNotificationSearchRespPb;
import com.tiwari.studence.pushNotification.provider.PushNotificationProvider;
import com.tiwari.studence.pushNotification.provider.PushNotificationSearchPbProvider;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;

public class PushNotificationConvertor extends
        AEntityConvertor<PushNotificationPb, PushNotificationPb.Builder, PushNotificationProvider, PushNotificationSearchReqPb, PushNotificationSearchReqPb.Builder, PushNotificationSearchRespPb, PushNotificationSearchRespPb.Builder, PushNotificationSearchPbProvider> {

  @Inject
  public PushNotificationConvertor(PushNotificationProvider builderProvider,
          JsonBaseEncoderDecoder jsonBaseEncoderDecoder,
          PushNotificationSearchPbProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
