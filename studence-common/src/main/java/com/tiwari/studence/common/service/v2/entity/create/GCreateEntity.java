package com.tiwari.studence.common.service.v2.entity.create;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.service.v2.interfaces.IAsyncConverter;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.interfaces.IEntityStore;
import com.tiwari.studence.common.service.v2.interfaces.IUpdater;
import com.tiwari.studence.common.util.GNormalizedProto;
import com.tiwari.studence.common.util.MergeAndTracking;
import com.tiwari.studence.common.util.ProtoMerger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GCreateEntity<Pb extends GeneratedMessageV3, UiPb extends GeneratedMessageV3, S extends IEntityStore<Pb>, C extends IAsyncConverter<Pb, UiPb>, U extends IUpdater<Pb, UiPb>>
        extends GCreateEntityWithExternalIdCheck<Pb, UiPb, S, C, U > {
  @Inject
  public GCreateEntity(S store, C converter, U updater,
          ProtoMerger protoMerger, MergeAndTracking enableMergeAndTrack,
          IEntityProtoWrapper<Pb> entityWrapper, GNormalizedProto protoNormatizer) {
    super(store, converter, updater, protoMerger, enableMergeAndTrack, entityWrapper,
            protoNormatizer);
  }
}
