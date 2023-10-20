package com.tiwari.studence.devices.searcher;

import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.devices.convertor.DevicesConvertor;
import com.tiwari.studence.devices.indexer.DevicesIndexer;
import com.tiwari.studence.devices.provider.DevicesProvider;
import com.tiwari.studence.devices.provider.DevicesSearchPbProvider;
import com.tiwari.studence.devices.provider.DevicesTableNameProvider;
import com.tiwari.studence.proto.devices.DeviceDetailsPb;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchReqPb;
import com.tiwari.studence.proto.devices.DeviceDetailsSearchRespPb;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DevicesSearcher extends AEntitySearcher<DeviceDetailsPb,DeviceDetailsPb.Builder, DevicesProvider, DeviceDetailsSearchReqPb,DeviceDetailsSearchReqPb.Builder, DeviceDetailsSearchRespPb,DeviceDetailsSearchRespPb.Builder, DevicesSearchPbProvider, DevicesConvertor, DevicesIndexer, DevicesTableNameProvider> {

  @Inject
  public DevicesSearcher(DevicesConvertor convertor, IDynamoSearchTable dyamodbSearchTable,
          DevicesTableNameProvider tableNameProvider,
          DevicesSearchPbProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }
}
