package com.tiwari.studence.organisation.updater;

import java.util.HashMap;

import javax.inject.Inject;

import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.organisation.indexer.OrganisationIndexer;
import com.tiwari.studence.organisation.provider.OrganisationPbProvider;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.entity.LifeTimeEnum;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationPb.Builder;
import com.tiwari.studence.util.Strings;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class OrganisationUpdater extends
        AEntityUpdater<OrganisationPb, OrganisationPb.Builder, OrganisationPbProvider, OrganisationIndexer> {

  @Inject
  public OrganisationUpdater(OrganisationIndexer indexer, OrganisationPbProvider builderProvider) {
    super(indexer, builderProvider);
    // TODO Auto-generated constructor stub
  }

  @Override
  public HashMap<String, AttributeValue> updater(OrganisationPb builder, EntityPb pb) {
    Builder orgBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(orgBuilder.getDbInfoBuilder(), pb);
    if (Strings.notEmpty(builder.getName())) {
      orgBuilder.setName(builder.getName().toLowerCase());
    }
    return super.updater(orgBuilder.build());
  }
}
