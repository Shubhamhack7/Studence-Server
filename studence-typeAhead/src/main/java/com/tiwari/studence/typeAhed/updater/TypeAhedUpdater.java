package com.tiwari.studence.typeAhed.updater;

import com.tiwari.studence.common.service.v1.updater.AEntityUpdater;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadPb;
import com.tiwari.studence.typeAhed.indexer.TypeAhedIndexer;
import com.tiwari.studence.typeAhed.provider.TypeAhedProvider;
import com.tiwari.studence.util.common.Strings;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class TypeAhedUpdater extends
        AEntityUpdater<TypeAheadPb, TypeAheadPb.Builder, TypeAhedProvider, TypeAhedIndexer> {

  @Inject
  public TypeAhedUpdater(TypeAhedIndexer indexer, TypeAhedProvider builderProvider) {
    super(indexer, builderProvider);
  }

  @Override
  public HashMap<String, AttributeValue> updater(TypeAheadPb builder, EntityPb pb) {
    TypeAheadPb.Builder typeAheadBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(typeAheadBuilder.getDbInfoBuilder(), pb);
    if (Strings.notEmpty(builder.getContext().getDbInfoId())) {
      typeAheadBuilder.getContextBuilder().setDbInfoId(builder.getContext().getDbInfoId());
    }
    if (Strings.notEmpty(builder.getContext().getName())) {
      typeAheadBuilder.getContextBuilder().setName(builder.getContext().getName());
    }
    return super.updater(typeAheadBuilder.build());
  }

}
