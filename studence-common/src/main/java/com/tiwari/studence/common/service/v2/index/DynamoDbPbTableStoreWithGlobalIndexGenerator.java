package com.tiwari.studence.common.service.v2.index;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.entity.controlflow.*;
import com.tiwari.studence.common.service.v2.handler.BatchItemGetResultHandler;
import com.tiwari.studence.common.service.v2.handler.GetItemResultHandler;
import com.tiwari.studence.common.service.v2.handler.ScanResultHandler;
import com.tiwari.studence.common.service.v2.helper.DynamoDbNextTokenWithTablePartitionHelper;
import com.tiwari.studence.common.service.v2.interfaces.IPbTableStore;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.common.service.v2.requestBuilder.*;
import com.tiwari.studence.common.service.v2.table.ATablePartitioner;
import com.tiwari.studence.proto.error.ErrorCategoryUiEnum;
import com.tiwari.studence.proto.index.IndexVersionPb;
import com.tiwari.studence.proto.search.PaginationRequestUiPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.proto.search.TablePartitionInfoUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Singleton
public class DynamoDbPbTableStoreWithGlobalIndexGenerator<T extends ITables<TP>, TP extends ATablePartitioner, Pb extends GeneratedMessageV3, B extends GeneratedMessageV3.Builder<B>, I extends SecondaryIndexGenerator<Pb>>
        implements IPbTableStore<Pb> {
  private final DynamoDbTableInfo<T> m_tableInfo;
  private final GetItemRequestBuilder<T> m_getRequestBuilder;
  private final GetItemResultHandler<Pb, B> m_getResponseHandler;
  private final CreateItemRequestBuilder<T> m_createRequestBuilder;
  private final UpdateItemRequestBuilder<T> m_updtaeRequestBuilder;
  private final ScanTableRequestBuilder m_scanRequestbuilder;
  private final ScanResultHandler<Pb, B> m_getScanHandler;
  private final DynamoDbNextTokenWithTablePartitionHelper m_dynamoDbNextTokenWithTablePartitionHelper;
  private final I m_secondaryIndexGenerator;
  private final TP m_tablePartitioner;
  private final BatchItemGetRequestBuilder m_batchItemGetRequestBuilder;
  private final BatchItemGetResultHandler<Pb, ?> m_batchItemGetResultHandler;

  @Inject
  public DynamoDbPbTableStoreWithGlobalIndexGenerator(
          DynamoDbNextTokenWithTablePartitionHelper dynamoDbNextTokenWithTablePartitionHelper,
          DynamoDbTableInfo<T> tableInfo, GetItemRequestBuilder<T> getRequestBuilder,
          GetItemResultHandler<Pb, B> getResponseHandler, TP tablePartitioner,
          CreateItemRequestBuilder<T> createRequestBuilder,
          UpdateItemRequestBuilder<T> updtaeRequestBuilder,
          ScanTableRequestBuilder scanRequestbuilder, ScanResultHandler<Pb, B> getScanHandler,
          I secondaryIndexGenerator, BatchItemGetRequestBuilder batchItemGetRequestBuilder,
          BatchItemGetResultHandler<Pb, B> batchItemGetResultHandler) {
    m_tableInfo = tableInfo;
    m_dynamoDbNextTokenWithTablePartitionHelper = dynamoDbNextTokenWithTablePartitionHelper;
    m_tablePartitioner = tablePartitioner;
    m_getRequestBuilder = getRequestBuilder;
    m_getResponseHandler = getResponseHandler;
    m_createRequestBuilder = createRequestBuilder;
    m_updtaeRequestBuilder = updtaeRequestBuilder;
    m_scanRequestbuilder = scanRequestbuilder;
    m_getScanHandler = getScanHandler;
    m_secondaryIndexGenerator = secondaryIndexGenerator;
    m_batchItemGetResultHandler = batchItemGetResultHandler;
    m_batchItemGetRequestBuilder = batchItemGetRequestBuilder;

  }

  @Override
  public IFuture<Pb, ErrorException> getItem(String id) {
    EntityLookupControlFlow<Pb> lookupCf = new EntityLookupControlFlow<>(m_tableInfo,
            m_getRequestBuilder, m_getResponseHandler, id);
    lookupCf.startAsyncCall();
    return lookupCf.getFutureResult();
  }

  @Override
  public IFuture<Pb, ErrorException> createItem(String id, Pb pb) {
    CreateControlFlow<Pb> cf = new CreateControlFlow<Pb>(m_tableInfo, m_createRequestBuilder,
            m_secondaryIndexGenerator, pb, id);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<Pb, ErrorException> updateItem(String id, Pb pb, int version) {
    UpdateControlFlow<Pb> cf = new UpdateControlFlow<>(m_tableInfo, m_updtaeRequestBuilder,
            m_secondaryIndexGenerator, pb, id, version);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, ErrorException> getScanTable(
          PaginationRequestUiPb request, Map<String, String> map,
          TablePartitionInfoUiPb partitionUiPb) {

    ScanTableCF<Pb> cf = new ScanTableCF<Pb>(m_tablePartitioner, partitionUiPb,
            m_dynamoDbNextTokenWithTablePartitionHelper, m_tableInfo, m_scanRequestbuilder, request,
            m_getScanHandler, map);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  /***
   * <p>
   * if data associated with Id's does not exist ,will be excluded from the
   * result. The ids which does not exist in either in Set or Map are basically
   * NOT FOUND
   * </p>
   *
   */

  @Override
  public IFuture<Pair<Set<String>, Map<String, Pb>>, ErrorException> batchGetItem(
          Set<String> idList) {
    BatchGetItemResultCF<Pb> cf = new BatchGetItemResultCF<Pb>(idList, m_tableInfo,
            m_batchItemGetRequestBuilder, m_batchItemGetResultHandler, false);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<IndexVersionPb, ErrorException> getIndexVersion(String id) {
    Preconditions.check(false, ErrorCategoryUiEnum.SELF_CODE_ERROR, "Not Supported");
    return null;
  }

}
