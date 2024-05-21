package com.tiwari.studence.common.service.v2.index;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.SyncFuture;
import com.tiwari.studence.common.async.WaitOnFutureAndExecuteRunnableControlFlow;
import com.tiwari.studence.common.service.v2.dynamodb.DynamoDbTableInfo;
import com.tiwari.studence.common.service.v2.entity.controlflow.*;
import com.tiwari.studence.common.service.v2.handler.BatchItemGetResultHandler;
import com.tiwari.studence.common.service.v2.handler.RangeResultHandler;
import com.tiwari.studence.common.service.v2.handler.ScanResultHandler;
import com.tiwari.studence.common.service.v2.helper.DynamoDbNextTokenWithTablePartitionHelper;
import com.tiwari.studence.common.service.v2.interfaces.IRangeTableStore;
import com.tiwari.studence.common.service.v2.interfaces.ISecondaryIndexEntity;
import com.tiwari.studence.common.service.v2.interfaces.ITables;
import com.tiwari.studence.common.service.v2.requestBuilder.*;
import com.tiwari.studence.common.service.v2.table.ATablePartitioner;
import com.tiwari.studence.proto.entity.EntityProtoPb;
import com.tiwari.studence.proto.entity.LifeTimeEnum;
import com.tiwari.studence.proto.search.PaginationRequestUiPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.proto.search.TablePartitionInfoUiPb;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.VoidException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

@Singleton
public class DynamoDbRangeTableStoreWithSecondaryIndex<Pb extends GeneratedMessageV3, T extends ITables<TP>, TP extends ATablePartitioner, B extends GeneratedMessageV3.Builder<B>, I extends SecondaryIndexGenerator<Pb>, IE extends ISecondaryIndexEntity>
        implements IRangeTableStore<Pb> {

  private final DynamoDbTableInfo<T> m_dbInfo;
  private final CreateRangeItemRequestBuilder<T> m_createRequestBuilder;
  private final UpdateRangeItemRequestBuilder<T> m_updateRequestBuilder;
  private final DeleteRangeItemRequestBuilder m_deleteRequestBuilder;
  private final ScanTableRequestBuilder m_requestBuilder;
  private final ScanResultHandler<Pb, ?> m_scanResultHandler;
  private final RangeRequestBuilder m_getRequestBuilder;
  private final RangeResultHandler<Pb, B> m_getResultHandler;
  private final DynamoDbNextTokenWithTablePartitionHelper m_dynamoDbNextTokenWithTablePartitionHelper;
  private final I m_secondaryIndexGenerator;
  private final IE m_secondaryIndexEntity;
  private final TP m_tablePartitioner;
  private final BatchItemGetRequestBuilder<?> m_batchItemGetRequestBuilder;
  private final BatchItemGetResultHandler<Pb, ?> m_resultHandler;

  @Inject
  public DynamoDbRangeTableStoreWithSecondaryIndex(ScanResultHandler<Pb, B> scanResultHandler,
          ScanTableRequestBuilder requestBuilder,
          DynamoDbNextTokenWithTablePartitionHelper dynamoDbNextTokenWithTablePartitionHelper,
          DynamoDbTableInfo<T> dbInfo, CreateRangeItemRequestBuilder<T> createRequestBuilder,
          UpdateRangeItemRequestBuilder<T> updateRequestBuilder,
          RangeRequestBuilder getRequestBuilder, RangeResultHandler<Pb, B> getResultHandler,
          DeleteRangeItemRequestBuilder deleteRequestBuilder, I secondaryIndexGenerator,
          IE globalIndexEntity, TP tablePartitioner,
          BatchItemGetRequestBuilder<T> batchItemGetRequestBuilder,
          BatchItemGetResultHandler<Pb, B> resultHandler) {
    m_dbInfo = dbInfo;
    m_requestBuilder = requestBuilder;
    m_scanResultHandler = scanResultHandler;
    m_dynamoDbNextTokenWithTablePartitionHelper = dynamoDbNextTokenWithTablePartitionHelper;
    m_createRequestBuilder = createRequestBuilder;
    m_updateRequestBuilder = updateRequestBuilder;
    m_getResultHandler = getResultHandler;
    m_getRequestBuilder = getRequestBuilder;
    m_deleteRequestBuilder = deleteRequestBuilder;
    m_secondaryIndexGenerator = secondaryIndexGenerator;
    m_secondaryIndexEntity = globalIndexEntity;
    m_tablePartitioner = tablePartitioner;
    m_batchItemGetRequestBuilder = batchItemGetRequestBuilder;
    m_resultHandler = resultHandler;
  }

  @Override
  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> getRange(String id,
          String startKey, String endKey, boolean ascending, TablePartitionInfoUiPb partitionUiPb,
          PaginationRequestUiPb pagination) {
    GetRangeCF<Pb> cf = new GetRangeCF<Pb>(m_dbInfo, m_secondaryIndexEntity, m_getRequestBuilder,
            m_getResultHandler, id, startKey, endKey, ascending, true, partitionUiPb, pagination,
            m_tablePartitioner);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> getPrefixRange(String id,
          String beginKey, boolean ascending, TablePartitionInfoUiPb partitionUiPb,
          PaginationRequestUiPb pagination) {
    GetRangeCF<Pb> cf = new GetRangeCF<Pb>(m_dbInfo, m_secondaryIndexEntity, m_getRequestBuilder,
            m_getResultHandler, id, beginKey, null, ascending, false, partitionUiPb, pagination,
            m_tablePartitioner);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<Pb, ErrorException> createItem(String id, String rangeKey, Pb pb) {
    CreateRangeItemCF<Pb> cf = new CreateRangeItemCF<Pb>(m_dbInfo, m_createRequestBuilder,
            m_secondaryIndexGenerator, pb, id, rangeKey);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<Pb, ErrorException> updateItem(String id, String rangeKey, Pb pb, int version) {
    UpdateRangeItemCF<Pb> cf = new UpdateRangeItemCF<Pb>(m_dbInfo, m_updateRequestBuilder,
            m_secondaryIndexGenerator, pb, id, rangeKey, version);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> getLargest(String id,
          String rangeKey, boolean includeMatch, TablePartitionInfoUiPb partitionUiPb,
          PaginationRequestUiPb pagination) {
    GetLargestCF<Pb> cf = new GetLargestCF<Pb>(m_dbInfo, m_secondaryIndexEntity,
            m_getRequestBuilder, m_getResultHandler, id, rangeKey, includeMatch, partitionUiPb,
            pagination, m_tablePartitioner);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> getSmallest(String id,
          String rangeKey, boolean includeMatch, TablePartitionInfoUiPb partitionUiPb,
          PaginationRequestUiPb pagination) {
    GetSmallestCF<Pb> cf = new GetSmallestCF<Pb>(m_dbInfo, m_secondaryIndexEntity,
            m_getRequestBuilder, m_getResultHandler, id, rangeKey, includeMatch, partitionUiPb,
            pagination, m_tablePartitioner);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<Pb, ErrorException> get(String id, String rangeKey) {
    GetItemCF<Pb> cf = new GetItemCF<Pb>(m_dbInfo, m_getRequestBuilder, m_getResultHandler, id,
            rangeKey);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  @Override
  public IFuture<Void, ErrorException> deleteEntity(String id, String rangeKey) {
    DeleteItemCF delCf = new DeleteItemCF(id, rangeKey, m_dbInfo, m_deleteRequestBuilder);
    delCf.startAsyncCall();
    return new SyncFuture<Void, ErrorException>();
  }

  @Override
  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> filerDeletedEntries(
          final IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, VoidException> iFuture) {

    return WaitOnFutureAndExecuteRunnableControlFlow.waitAndExecuteCallable(
            new Callable<Pair<SearchResultSummaryUiPb, List<Pb>>>() {

              @Override
              public Pair<SearchResultSummaryUiPb, List<Pb>> call() throws ErrorException {
                List<Pb> m_filteredPb = Lists.newArrayList();

                for (int i = 0; i < iFuture.get().getSecond().size(); i++) {
                  EntityProtoPb pb = (EntityProtoPb) iFuture.get().getSecond().get(i).getField(
                          iFuture.get().getSecond().get(i).getDescriptorForType()
                                  .findFieldByNumber(1));
                  if (pb.getLifetimeState() != LifeTimeEnum.DELETED) {
                    m_filteredPb.add(iFuture.get().getSecond().get(i));
                  }
                }

                return new Pair<SearchResultSummaryUiPb, List<Pb>>(iFuture.get().getFirst(),
                        m_filteredPb);
              }
            }, iFuture);

  }

  @Override
  public IFuture<Pair<SearchResultSummaryUiPb, List<Pb>>, ErrorException> getScanTable(
          PaginationRequestUiPb request, Map<String, String> map,
          TablePartitionInfoUiPb partitionUiPb) {
    ScanTableCF<Pb> cf = new ScanTableCF<Pb>(m_tablePartitioner, partitionUiPb,
            m_dynamoDbNextTokenWithTablePartitionHelper, m_dbInfo, m_requestBuilder, request,
            m_scanResultHandler, map);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  /***
   * <p>
   * if data associated with Id's does not exist ,will be excluded from the
   * result. The id's which does not exist in either in Set or Map are basically
   * NOT FOUND.
   * </p>
   *
   */
  @Override
  public IFuture<Pair<Set<String>, Map<String, Pb>>, ErrorException> batchGetItem(
          Set<String> idList) {
    BatchGetItemResultCF<Pb> cf = new BatchGetItemResultCF<Pb>(idList, m_dbInfo,
            m_batchItemGetRequestBuilder, m_resultHandler, true);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

}
