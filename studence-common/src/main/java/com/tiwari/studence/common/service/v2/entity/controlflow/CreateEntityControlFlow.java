package com.tiwari.studence.common.service.v2.entity.controlflow;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.AControlFlow;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.interfaces.IAsyncConverter;
import com.tiwari.studence.common.service.v2.interfaces.IEntityProtoWrapper;
import com.tiwari.studence.common.service.v2.interfaces.IEntityStore;
import com.tiwari.studence.common.service.v2.interfaces.IUpdater;
import com.tiwari.studence.common.util.GNormalizedProto;
import com.tiwari.studence.common.util.MergeAndTracking;
import com.tiwari.studence.common.util.ProtoMerger;
import com.tiwari.studence.proto.entity.EntityChangeTeamTypeUiEnum;
import com.tiwari.studence.proto.entity.EntityProtoPb;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.log.DebugLogger;

import javax.inject.Inject;
import java.util.List;

public class CreateEntityControlFlow<PB extends GeneratedMessageV3, UiPb extends GeneratedMessageV3, S extends IEntityStore<PB>>
        extends AControlFlow<CreateEntityControlFlow.States, UiPb, ErrorException> {

  private final UiPb m_req;
  private PB m_pb;
  private final S m_store;
  private final IAsyncConverter<PB, UiPb> m_converter;
  private final IUpdater<PB, UiPb> m_updater;
  //private final ExternalIdsSearcher<?, ?, UiPb> m_externalIdSearcher;
  private final ProtoMerger m_protoMerger;
  private final MergeAndTracking m_enableMergeAndTrack;
  private final IEntityProtoWrapper<PB> m_entityWrapper;
  private final GNormalizedProto m_protoNormatizer;
  private IFuture<Pair<SearchResultSummaryUiPb, List<UiPb>>, ErrorException> m_externalIdCheckFuture;

  @Inject
  public CreateEntityControlFlow(UiPb req, S store, IUpdater<PB, UiPb> updater,
          IAsyncConverter<PB, UiPb> converter, /*ExternalIdsSearcher<?, ?, UiPb> externalIdSearcher,*/
          ProtoMerger protoMerger, MergeAndTracking enableMergeAndTrack,
          IEntityProtoWrapper<PB> entityWrapper, GNormalizedProto protoNormatizer) {
    super(States.START_EXT_ID_CHECK, States.DONE);
    addStateHandler(States.START_EXT_ID_CHECK, new ExternalIdCheckStateHandler());
    addStateHandler(States.UPDATE_ENTITY_FROM_REQ, new UpdateEntityFromRequestStateHandler());
    addStateHandler(States.VALIDATE_CREATE, new ValidateCreateStateHandler());
    addStateHandler(States.CREATE_ENTITY_AND_CONVERT_TO_RESP,
            new CreateEntityAndConvertToRespStateHandler());
    m_req = req;
    m_store = store;
    m_updater = updater;
    m_converter = converter;
    m_protoMerger = protoMerger;
    m_enableMergeAndTrack = enableMergeAndTrack;
    m_entityWrapper = entityWrapper;
    m_protoNormatizer = protoNormatizer;
  }

  public enum States {
    START_EXT_ID_CHECK,
    UPDATE_ENTITY_FROM_REQ,
    VALIDATE_CREATE,
    CREATE_ENTITY_AND_CONVERT_TO_RESP,
    DONE;
  }

  private class ExternalIdCheckStateHandler implements StateHandler<States> {
    @Override
    public void registerCalls() {

      DebugLogger.info("here");
    //  m_externalIdCheckFuture = m_externalIdSearcher.search(m_req);
    }

    @Override
    public States handleState() {
      return States.UPDATE_ENTITY_FROM_REQ;
    }
  }

  private class UpdateEntityFromRequestStateHandler implements StateHandler<States> {
    @Override
    public void registerCalls() {
    }

    @Override
    public States handleState() {
      try {
        m_pb = m_updater.create(m_req);
        if (m_enableMergeAndTrack.enableTracking()) {
          EntityProtoPb entityProtoPb = m_entityWrapper.getEntityProto(m_pb);
          Preconditions
                  .validate(
                          entityProtoPb.getLastChangeTrack().getTeamType() != EntityChangeTeamTypeUiEnum.UNKNOWN_TEAM_TYPE,
                          ErrorTypePbEnum.VALIDATION_FAILED, entityProtoPb, entityProtoPb
                                  .getLastChangeTrack().getTeamType().name());
          Preconditions.validate(
                  Strings.notEmpty(entityProtoPb.getLastChangeTrack().getSourceTeam().getTeamId())
                          || entityProtoPb.getLastChangeTrack().getIsSelfProfileCreate(),
                  ErrorTypePbEnum.VALIDATION_FAILED, m_pb);
          Preconditions.validate(
                  entityProtoPb.getLastChangeTrack().getTime().getUnixTimestampMs() != 0,
                  ErrorTypePbEnum.VALIDATION_FAILED, m_pb, entityProtoPb.getLastChangeTrack()
                          .getTime().getUnixTimestampMs());
          if (entityProtoPb.getLastChangeTrack().getTeamType() == EntityChangeTeamTypeUiEnum.SELF_SUPPORT_TEAM
                  || entityProtoPb.getLastChangeTrack().getTeamType() == EntityChangeTeamTypeUiEnum.INTERNAL_AND_OUTSOURCED_COMPANY_CUPPORT_TEAM) {
            Preconditions.validate(
                    Strings.notEmpty(entityProtoPb.getLastChangeTrack().getSourceSupportTeam()
                            .getTeamId()), ErrorTypePbEnum.VALIDATION_FAILED, m_pb);
          }
        }
        if (m_enableMergeAndTrack.enableMerge()) {
          // Move merge etc to EntityStore...
          EntityProtoPb entityProtoPb = m_entityWrapper.getEntityProto(m_pb);
          m_pb = (PB) m_protoMerger.merge((GeneratedMessageV3) m_pb.getDefaultInstanceForType(),
                  m_pb, entityProtoPb.getLastChangeTrack().getSourceRefId(),
                  entityProtoPb.getLastChangeTrack().getMatchedTime(), null, true).getFirst();
          EntityProtoPb.Builder clearMergeData = EntityProtoPb.newBuilder(entityProtoPb);
          clearMergeData.getLastChangeTrackBuilder().clearSourceRefId();
          clearMergeData.getLastChangeTrackBuilder().clearMatchedTime();
          m_pb = m_entityWrapper.setEntityProto(m_pb, clearMergeData.build());
        }
        m_pb = (PB) m_protoNormatizer.getNormalizedProto(m_pb);
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
        return States.DONE;
      }
      return States.VALIDATE_CREATE;
    }
  }

  private class ValidateCreateStateHandler implements StateHandler<States> {
    @Override
    public void registerCalls() {
      registerFutures(m_externalIdCheckFuture);
    }

    @Override
    public States handleState() {
      try {
        Pair<SearchResultSummaryUiPb, List<UiPb>> extIdsList = m_externalIdCheckFuture.get();

        if (extIdsList.getSecond().size() > 0) {
          getAsyncCallback().handleException(0,
                  new ErrorException(ErrorTypePbEnum.VALIDATION_FAILED, m_req));
          return States.DONE;
        } else {
          return States.CREATE_ENTITY_AND_CONVERT_TO_RESP;
        }
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
        return States.DONE;
      }
    }
  }

  private class CreateEntityAndConvertToRespStateHandler implements StateHandler<States> {
    IFuture<UiPb, ErrorException> insertedFuture;

    @Override
    public void registerCalls() {
      CreateEntityInternalCF<PB, UiPb, S> cf = new CreateEntityInternalCF<PB, UiPb, S>(m_pb,
              m_store, m_converter, null);
      cf.startAsyncCall();
      insertedFuture = cf.getFutureResult();
      registerFutures(insertedFuture);
    }

    @Override
    public States handleState() {
      try {
        UiPb resp = insertedFuture.get();
        getAsyncCallback().set(0, resp);
      } catch (ErrorException e) {
        getAsyncCallback().handleException(0, e);
        return States.DONE;
      }
      return States.DONE;
    }
  }
}
