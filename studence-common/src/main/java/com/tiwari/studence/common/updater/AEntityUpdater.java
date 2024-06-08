package com.tiwari.studence.common.updater;

import java.util.HashMap;

import javax.inject.Inject;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3.Builder;
import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.proto.entity.EntityPb;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public abstract class AEntityUpdater<P extends GeneratedMessageV3, BU extends GeneratedMessageV3.Builder, BP extends IPbBuilderProvider<P,BU>, I extends AEntityIndexer<P>>
        implements IUpdater<P> {

  private I m_indexer;
  private BP m_builderProvider;

  @Inject
  public AEntityUpdater(I indexer, BP builderProvider) {
    m_indexer = indexer;
    m_builderProvider = builderProvider;
  }

  @Override
  public HashMap<String, AttributeValue> updater(P builder) {
    return m_indexer.indexer(builder);
  }
  
  public HashMap<String, AttributeValue> updater(P builder,EntityPb pb) {
    return updater(builder);
  }

  public I getIndexer() {
    return m_indexer;
  }

  public BP getBuilderProvider() {
    return m_builderProvider;
  }
  
//  public void updateEntityBuilder(BU builder ,EntityPb updateBuilder) {
//    builder.mergeFrom(updateBuilder);
//    return ;
//  }
  public void updateEntityBuilder(Builder<?> builder ,EntityPb updateBuilder) {
    builder.mergeFrom(updateBuilder);
    return ;
  }
}
