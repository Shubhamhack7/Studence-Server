package com.tiwari.studence.common.updater;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.refConvertor.IRefConvetor;
import com.tiwari.studence.common.refUpdater.AEntityRefUpdator;
import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Quadlets;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public abstract class AEntityUpdater<P extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P, BU>, I extends AEntityIndexer<P>>
        extends AEntityRefUpdator implements IUpdater<P> {

  private I m_indexer;
  private BP m_builderProvider;
  private List<Quadlets<IEntityService, IRefConvetor, GeneratedMessageV3.Builder, String>> reflist = Lists.newArrayList();

  @Inject
  public AEntityUpdater(I indexer, BP builderProvider) {
    m_indexer = indexer;
    m_builderProvider = builderProvider;
  }

  @Override
  public HashMap<String, AttributeValue> updater(P builder) {

    return m_indexer.indexer(builder);
  }

  public void updateRef() {
    super.refUpdater(reflist);
  }

  public HashMap<String, AttributeValue> updater(P builder, EntityPb pb) {
    return updater(builder);
  }

  public I getIndexer() {
    return m_indexer;
  }

  public BP getBuilderProvider() {
    return m_builderProvider;
  }

  public void addRefintoList(
          Quadlets<IEntityService, IRefConvetor, GeneratedMessageV3.Builder, String> quad) {
    reflist.add(quad);
  }

  public void addRefintoList(IEntityService service, IRefConvetor con,
          GeneratedMessageV3.Builder bu, String s) {
    reflist.add(
            new Quadlets<IEntityService, IRefConvetor, GeneratedMessageV3.Builder, String>(service,
                    con, bu, s));
  }

  public void updateEntityBuilder(Builder<?> builder, EntityPb updateBuilder) {
    builder.mergeFrom(updateBuilder);
  }
}
