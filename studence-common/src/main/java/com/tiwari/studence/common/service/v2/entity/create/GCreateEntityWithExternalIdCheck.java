package com.tiwari.studence.common.service.v2.entity.create;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v1.services.interfaces.ICreateEntity;
import com.tiwari.studence.common.service.v2.entity.controlflow.CreateEntityControlFlow;
import com.tiwari.studence.common.service.v2.interfaces.IAsyncConverter;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.interfaces.IEntityStore;
import com.tiwari.studence.common.service.v2.interfaces.IUpdater;
import com.tiwari.studence.common.util.GNormalizedProto;
import com.tiwari.studence.common.util.MergeAndTracking;
import com.tiwari.studence.common.util.ProtoMerger;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public abstract class GCreateEntityWithExternalIdCheck<Pb extends GeneratedMessageV3, UiPb extends GeneratedMessageV3, S extends IEntityStore<Pb>, C extends IAsyncConverter<Pb, UiPb>, U extends IUpdater<Pb, UiPb> /*ExtIdSearcher extends com.tiwari.studence.common.service.v2.searcher.GIndexPbSearcher<?, ?, UiPb, UiPb>*/>
        implements ICreateEntity<UiPb> {
  private final S m_store;
  private final U m_updater;
  private final C m_converter;
 // private final ExtIdSearcher m_searcher;
  private final ProtoMerger m_protoMerger;
  private final MergeAndTracking m_enableMergeAndTrack;
  private final IEntityProtoWrapper<Pb> m_entityWrapper;
  private final GNormalizedProto m_protoNormatizer;

  @Inject
  public GCreateEntityWithExternalIdCheck(S store, C converter, U updater,
           ProtoMerger protoMerger, MergeAndTracking enableMergeAndTrack,
          IEntityProtoWrapper<Pb> entityWrapper, GNormalizedProto protoNormatizer) {
    m_store = store;
    m_updater = updater;
    m_converter = converter;
    m_protoMerger = protoMerger;
    m_enableMergeAndTrack = enableMergeAndTrack;
    m_entityWrapper = entityWrapper;
    m_protoNormatizer = protoNormatizer;
  }

  @Override
  public IFuture<UiPb, ErrorException> createEntity(UiPb request) {
    CreateEntityControlFlow<Pb, UiPb, S> cf = new CreateEntityControlFlow<Pb, UiPb, S>(request,
            m_store, m_updater, m_converter,/* m_searcher,*/ m_protoMerger, m_enableMergeAndTrack,
            m_entityWrapper, m_protoNormatizer);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
