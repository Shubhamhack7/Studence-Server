package com.tiwari.studence.common.service.v2.index;

import com.amazonaws.services.simpledb.model.SelectRequest;
import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.WaitOnFutureAndExecuteRunnableControlFlow;
import com.tiwari.studence.common.service.v2.entity.create.CreateOrUpdateCF;
import com.tiwari.studence.common.service.v2.interfaces.IIndexTableStore;
import com.tiwari.studence.common.service.v2.interfaces.ITableUpdateListener;
import com.tiwari.studence.common.service.v2.listener.TableUpdateListenerNotifier;
import com.tiwari.studence.proto.entity.EntityProtoUiPb;
import com.tiwari.studence.proto.index.IndexField;
import com.tiwari.studence.proto.index.IndexPb;
import com.tiwari.studence.proto.index.IndexVersionPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.VoidException;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class GIndexStore<IndexTableStore extends IIndexTableStore, Ul extends ITableUpdateListener<IndexPb>, SearchPb extends GeneratedMessageV3, B extends GeneratedMessageV3.Builder<B>> {
  private final IndexTableStore m_indexTableStore;
  private final Ul m_tableUpdateListener;
  private final TableUpdateListenerNotifier m_notifier;
  private final IndexToSearchPbResultsConverter<SearchPb, B> m_converter;

  @Inject
  public GIndexStore(IndexTableStore indexTableStore, Ul tableUpdateListener,
          TableUpdateListenerNotifier notifier,
          IndexToSearchPbResultsConverter<SearchPb, B> decoder) {
    m_indexTableStore = indexTableStore;
    m_tableUpdateListener = tableUpdateListener;
    m_notifier = notifier;
    m_converter = decoder;
  }

  public IFuture<IndexVersionPb, ErrorException> getIndexVersion(String id) {
    return m_indexTableStore.getIndexVersion(id);
  }

  public IFuture<IndexPb, ErrorException> getItem(String id) {
    return m_indexTableStore.getItem(id);
  }

  public IFuture<IndexPb, ErrorException> createItem(IndexPb pb) {
    IndexPb.Builder index = IndexPb.newBuilder(pb);
    index.getEntityProtoBuilder().setVersion(1);
    IFuture<IndexPb, ErrorException> createFuture = m_indexTableStore.createItem(
            pb.getEntityProto().getId(), index.build());
    m_notifier.notifyCreate(m_tableUpdateListener, createFuture);
    return createFuture;
  }

  public IFuture<IndexPb, ErrorException> updateItem(IndexPb pb) {
    IndexPb.Builder index = IndexPb.newBuilder(pb);
    index.getEntityProtoBuilder().setVersion(pb.getEntityProto().getVersion() + 1);
    IFuture<IndexPb, ErrorException> updateFuture = m_indexTableStore.updateItem(
            pb.getEntityProto().getId(), index.build(), pb.getEntityProto().getVersion() + 1);
    m_notifier.notifyUpdate(m_tableUpdateListener, updateFuture);
    return updateFuture;
  }

  // This is not update conflict safe.
  public IFuture<IndexPb, ErrorException> deleteItem(final IndexPb pb) {
    IFuture<Void, ErrorException> deleteFutureSt = m_indexTableStore.deleteItem(
            pb.getEntityProto().getId());
    ALoggableCallable<IndexPb> syncCall = new ALoggableCallable<IndexPb>() {
      @Override
      public IndexPb call() {
        return pb;
      }
    };
    IFuture<IndexPb, ErrorException> deleteFuture = WaitOnFutureAndExecuteRunnableControlFlow.waitAndExecuteCallable(
            syncCall, deleteFutureSt);
    m_notifier.notifyDelete(m_tableUpdateListener, deleteFuture);
    return deleteFuture;
  }

  public IFuture<IndexPb, ErrorException> createOrUpdateItem(IndexPb pb) {
    EntityProtoUiPb entityPb = m_converter.getEntityProtoFromPb(pb);
    IndexPb.Builder builder = IndexPb.newBuilder(pb);
    IndexField.Builder fieldbuilder = builder.addFieldsBuilder();
    fieldbuilder.setType(IndexField.Type.EXACT);
    fieldbuilder.setFieldName(EntityIndexAttributes.ENTITY_VERSION.name());
    fieldbuilder.addFieldValues(String.valueOf(entityPb.getVersion()));

    CreateOrUpdateCF cf = new CreateOrUpdateCF(this, builder.build(), entityPb);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }

  public IFuture<Pair<SearchResultSummaryUiPb, List<SearchPb>>, VoidException> search(
          SelectRequest req) {// can pass pagination and ParitionUiPb
    final IFuture<Pair<SearchResultSummaryUiPb, List<IndexPb>>, VoidException> indexPbResults = m_indexTableStore.search(
            req);
    ALoggableCallable<Pair<SearchResultSummaryUiPb, List<SearchPb>>> callable = new ALoggableCallable<Pair<SearchResultSummaryUiPb, List<SearchPb>>>(
            req) {
      @Override
      public Pair<SearchResultSummaryUiPb, List<SearchPb>> call() throws ErrorException {
        return m_converter.getResults(indexPbResults.get());
      }
    };
    return WaitOnFutureAndExecuteRunnableControlFlow.waitAndExecuteCallable(callable,
            indexPbResults);
  }

  public IFuture<Integer, VoidException> searchCount(SelectRequest req) {
    return m_indexTableStore.searchCount(req);
  }

}

