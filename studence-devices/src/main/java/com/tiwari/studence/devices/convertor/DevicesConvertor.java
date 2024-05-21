package com.tiwari.studence.devices.convertor;

import com.tiwari.studence.common.service.v1.convertor.AEntityConvertor;
import com.tiwari.studence.devices.provider.DevicesProvider;
import com.tiwari.studence.devices.provider.DevicesSearchPbProvider;
import com.tiwari.studence.proto.devices.DeviceDetailsPb;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchReqPb;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchRespPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;

import javax.inject.Inject;

public class DevicesConvertor extends AEntityConvertor<DeviceDetailsPb,DeviceDetailsPb.Builder, DevicesProvider, DeviceDetailsSearchReqPb,DeviceDetailsSearchReqPb.Builder, DeviceDetailsSearchRespPb,DeviceDetailsSearchRespPb.Builder, DevicesSearchPbProvider> {

  @Inject
  public DevicesConvertor(DevicesProvider builderProvider,
          JsonBaseEncoderDecoder jsonBaseEncoderDecoder, DevicesSearchPbProvider respProvider) {
    super(builderProvider, jsonBaseEncoderDecoder, respProvider);
  }
}
