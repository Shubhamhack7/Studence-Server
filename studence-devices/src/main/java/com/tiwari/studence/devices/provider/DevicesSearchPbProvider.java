package com.tiwari.studence.devices.provider;

import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchReqPb;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchRespPb;

public class DevicesSearchPbProvider implements
        IReqRespPbBuilderProvider<DeviceDetailsSearchReqPb,DeviceDetailsSearchReqPb.Builder, DeviceDetailsSearchRespPb,DeviceDetailsSearchRespPb.Builder> {
  @Override
  public DeviceDetailsSearchReqPb.Builder getReqBuilder() {
    return DeviceDetailsSearchReqPb.newBuilder();
  }

  @Override
  public DeviceDetailsSearchReqPb.Builder getReqBuilder(DeviceDetailsSearchReqPb builder) {
    return DeviceDetailsSearchReqPb.newBuilder(builder);
  }

  @Override
  public DeviceDetailsSearchRespPb.Builder getRespBuilder() {
    return DeviceDetailsSearchRespPb.newBuilder();
  }

  @Override
  public DeviceDetailsSearchRespPb.Builder getRespBuilder(DeviceDetailsSearchRespPb builder) {
    return DeviceDetailsSearchRespPb.newBuilder(builder);
  }
}
