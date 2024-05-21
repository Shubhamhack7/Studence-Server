package com.tiwari.studence.devices.service;

import com.tiwari.studence.common.service.v1.services.interfaces.IEntityService;
import com.tiwari.studence.proto.devices.DeviceDetailsPb;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchReqPb;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchRespPb;

public interface IDevicesService extends
        IEntityService<DeviceDetailsPb, DeviceDetailsSearchReqPb, DeviceDetailsSearchRespPb> {
}
