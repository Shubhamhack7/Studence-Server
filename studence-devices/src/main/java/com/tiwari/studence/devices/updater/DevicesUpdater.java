package com.tiwari.studence.devices.updater;

import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.devices.indexer.DevicesIndexer;
import com.tiwari.studence.devices.provider.DevicesProvider;
import com.tiwari.studence.proto.devices.DeviceAppMode;
import com.tiwari.studence.proto.devices.DeviceDetailsPb;
import com.tiwari.studence.proto.devices.DeviceOSTypeEnum;
import com.tiwari.studence.proto.devices.DeviceTypeEnum;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.helper.DeviceHelper;
import com.tiwari.studence.util.helper.PushNotificationHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import java.util.HashMap;

public class DevicesUpdater extends
        AEntityUpdater<DeviceDetailsPb, DeviceDetailsPb.Builder, DevicesProvider, DevicesIndexer> {

  private DeviceHelper m_deviceHelper;
  private PushNotificationHelper m_pushNotificationHelper;

  @Inject
  public DevicesUpdater(DevicesIndexer indexer, DevicesProvider builderProvider,
          DeviceHelper deviceHelper, PushNotificationHelper pushNotificationHelper) {
    super(indexer, builderProvider);
    m_deviceHelper = deviceHelper;
    m_pushNotificationHelper = pushNotificationHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(DeviceDetailsPb builder, EntityPb pb) {
    DeviceDetailsPb.Builder orgBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(orgBuilder.getDbInfoBuilder(), pb);
    if (builder.getDeviceOsType() != DeviceOSTypeEnum.UNKNOWN_OS) {
      orgBuilder.setDeviceOsType(builder.getDeviceOsType());
    }
    m_deviceHelper.updateAndroidDeviceDetails(orgBuilder.getAndroidDeviceBuilder(),
            builder.getAndroidDevice());
    m_deviceHelper.updateIOSDeviceDetails(orgBuilder.getIosDeviceBuilder(), builder.getIosDevice());
    m_deviceHelper.updateWindowsDeviceDetails(orgBuilder.getWindowsDeviceBuilder(),
            builder.getWindowsDevice());
    m_deviceHelper.updateMacOSDeviceDetails(orgBuilder.getMacOsDeviceBuilder(),
            builder.getMacOsDevice());
    m_deviceHelper.updateWebBrowserInfoDetails(orgBuilder.getWebBrowserDeviceBuilder(),
            builder.getWebBrowserDevice());
    m_deviceHelper.updateLinuxDeviceInfoDetails(orgBuilder.getLinuxDeviceBuilder(),
            builder.getLinuxDevice());
    m_deviceHelper.updateDeviceScreenSize(orgBuilder.getScreeSizeBuilder(), builder.getScreeSize());
    if (Strings.notEmpty(builder.getDeviceMacId())) {
      orgBuilder.setDeviceMacId(builder.getDeviceMacId());
    }
    if (Strings.notEmpty(builder.getDeviceIpAddress().getDeviceIpAddress())) {
      m_deviceHelper.updateDeviceIpAddress(orgBuilder.getDeviceIpAddressBuilder(),
              builder.getDeviceIpAddress());
    }
    if (Strings.notEmpty(builder.getUniqueId())) {
      orgBuilder.setUniqueId(builder.getUniqueId());
    } else {
      orgBuilder.setUniqueId(m_deviceHelper.genreateUniqueId(builder));
    }
    if (builder.getMode() != DeviceAppMode.UKNOWN_MODE) {
      orgBuilder.setMode(builder.getMode());
    }
    if (builder.getDeviceType() != DeviceTypeEnum.UNKNOWN_DEVICE_TYPE) {
      orgBuilder.setDeviceType(builder.getDeviceType());
    }
   /* m_pushNotificationHelper.updatePushNotificationRef(orgBuilder.getPushNotificationRefBuilder(),
            builder.getPushNotificationRef());*/
    if (Strings.notEmpty(builder.getDeviceId())) {
      orgBuilder.setDeviceId(builder.getDeviceId());
    }
    return super.updater(orgBuilder.build());
  }
}
