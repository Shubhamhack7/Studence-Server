package com.tiwari.studence.devices.indexer;

import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.proto.devices.DeviceDetailsPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class DevicesIndexer extends AEntityIndexer<DeviceDetailsPb> {

  @Inject
  public DevicesIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(DeviceDetailsPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, DevicesIndexerEnum.DEVICE_OS_TYPE.name(),
            builder.getDeviceOsType().name(), false, AttributeValue.Type.S,
            DevicesIndexerEnum.DEVICE_OS_TYPE.isLowerCase());
    addItemToAttritibeMap(items, DevicesIndexerEnum.DEVICE_IP_ADDRESS.name(),
            builder.getDeviceIpAddress(), false, AttributeValue.Type.S,
            DevicesIndexerEnum.DEVICE_IP_ADDRESS.isLowerCase());
    addItemToAttritibeMap(items, DevicesIndexerEnum.DEVICE_UNIQUE_ID.name(),
            builder.getUniqueId(), false, AttributeValue.Type.S,
            DevicesIndexerEnum.DEVICE_UNIQUE_ID.isLowerCase());
    return items;
  }
}
