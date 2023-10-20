package com.tiwari.studence.devices.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.devices.service.DevicesService;
import com.tiwari.studence.devices.service.IDevicesService;

public class DevicesModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(IDevicesService.class).to(DevicesService.class);
  }
}
