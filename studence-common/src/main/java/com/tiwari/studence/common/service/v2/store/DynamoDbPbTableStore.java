package com.tiwari.studence.common.service.v2.store;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.handler.BatchItemGetResultHandler;
import com.tiwari.studence.common.service.v2.handler.GetItemResultHandler;
import com.tiwari.studence.common.service.v2.handler.ScanResultHandler;
import com.tiwari.studence.common.service.v2.helper.DynamoDbNextTokenWithTablePartitionHelper;
import com.tiwari.studence.common.service.v2.index.DynamoDbPbTableStoreWithGlobalIndexGenerator;
import com.tiwari.studence.common.service.v2.index.SecondaryIndexGenerator;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.common.service.v2.requestBuilder.*;
import com.tiwari.studence.common.service.v2.table.ATablePartitioner;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DynamoDbPbTableStore<T extends ITables<TP>, TP extends ATablePartitioner, Pb extends GeneratedMessageV3, B extends GeneratedMessageV3.Builder<B>>
        extends
        DynamoDbPbTableStoreWithGlobalIndexGenerator<T, TP, Pb, B, SecondaryIndexGenerator<Pb>> {
  @Inject
  public DynamoDbPbTableStore(
          DynamoDbNextTokenWithTablePartitionHelper dynamoDbNextTokenWithTablePartitionHelper,
          DynamoDbTableInfo<T> tableInfo, GetItemRequestBuilder<T> getRequestBuilder,
          GetItemResultHandler<Pb, B> getResponseHandler, TP tablePartitioner,
          CreateItemRequestBuilder<T> createRequestBuilder,
          UpdateItemRequestBuilder<T> updtaeRequestBuilder,
          ScanTableRequestBuilder scanRequestbuilder, ScanResultHandler<Pb, B> getScanHandler,
          SecondaryIndexGenerator<Pb> secondaryIndexGenerator,
          BatchItemGetRequestBuilder<T> batchItemGetRequestBuilder,
          BatchItemGetResultHandler<Pb, B> batchItemGetResultHandler) {
    super(dynamoDbNextTokenWithTablePartitionHelper, tableInfo, getRequestBuilder,
            getResponseHandler, tablePartitioner, createRequestBuilder, updtaeRequestBuilder,
            scanRequestbuilder, getScanHandler, secondaryIndexGenerator, batchItemGetRequestBuilder,
            batchItemGetResultHandler);

  }
}