package com.tiwari.studence.common.service.v2.store;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.handler.BatchItemGetResultHandler;
import com.tiwari.studence.common.service.v2.handler.RangeResultHandler;
import com.tiwari.studence.common.service.v2.handler.ScanResultHandler;
import com.tiwari.studence.common.service.v2.helper.DynamoDbNextTokenWithTablePartitionHelper;
import com.tiwari.studence.common.service.v2.index.DynamoDbRangeTableStoreWithSecondaryIndex;
import com.tiwari.studence.common.service.v2.index.SecondaryIndexGenerator;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.common.service.v2.requestBuilder.*;
import com.tiwari.studence.common.service.v2.table.ATablePartitioner;
import com.tiwari.studence.common.util.VoidEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DynamoDbRangeTableStore<Pb extends GeneratedMessageV3, T extends ITables<TP>, TP extends ATablePartitioner, B extends GeneratedMessageV3.Builder<B>>
        extends
        DynamoDbRangeTableStoreWithSecondaryIndex<Pb, T, TP, B, SecondaryIndexGenerator<Pb>, VoidEntity> {

  @Inject
  public DynamoDbRangeTableStore(ScanResultHandler<Pb, B> scanResultHandler,
          ScanTableRequestBuilder requestBuilder,
          DynamoDbNextTokenWithTablePartitionHelper dynamoDbNextTokenWithTablePartitionHelper,
          DynamoDbTableInfo<T> dbInfo, CreateRangeItemRequestBuilder<T> createRequestBuilder,
          UpdateRangeItemRequestBuilder<T> updateRequestBuilder,
          RangeRequestBuilder getRequestBuilder, RangeResultHandler<Pb, B> getResultHandler,
          DeleteRangeItemRequestBuilder deleteRequestBuilder,
          SecondaryIndexGenerator<Pb> secondaryIndexGenerator, VoidEntity globalIndexEntity,
          TP tablePartitioner, BatchItemGetRequestBuilder<T> batchItemGetRequestBuilder,
          BatchItemGetResultHandler<Pb, B> resultHandler) {
    super(scanResultHandler, requestBuilder, dynamoDbNextTokenWithTablePartitionHelper, dbInfo,
            createRequestBuilder, updateRequestBuilder, getRequestBuilder, getResultHandler,
            deleteRequestBuilder, secondaryIndexGenerator, globalIndexEntity, tablePartitioner,
            batchItemGetRequestBuilder, resultHandler);
  }

}
