package com.tiwari.studence.devices.provider;

import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.proto.devices.DeviceDetailsPb;

public class DevicesProvider implements IPbBuilderProvider<DeviceDetailsPb,DeviceDetailsPb.Builder> {

  @Override
  public DeviceDetailsPb.Builder getBuilder() {
    return DeviceDetailsPb.newBuilder();
  }

  @Override
  public DeviceDetailsPb.Builder getBuilder(DeviceDetailsPb builder) {
    return DeviceDetailsPb.newBuilder(builder);
  }
}
