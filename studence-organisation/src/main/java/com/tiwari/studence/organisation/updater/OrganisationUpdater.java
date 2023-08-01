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

import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class OrganisationUpdater extends
        AEntityUpdater<OrganisationPb, OrganisationPb.Builder, OrganisationPbProvider, OrganisationIndexer> {
 private NameHelper m_nameHelper;
 private ContactDetailsHelper m_contactDetailsHelper;

  @Inject
  public OrganisationUpdater(OrganisationIndexer indexer, OrganisationPbProvider builderProvider,NameHelper nameHelper,ContactDetailsHelper contactDetailsHelper) {
    super(indexer, builderProvider);
    // TODO Auto-generated constructor stub
    m_nameHelper=nameHelper;
    m_contactDetailsHelper= contactDetailsHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(OrganisationPb builder, EntityPb pb) {
    Builder orgBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(orgBuilder.getDbInfoBuilder(), pb);
    if (Strings.notEmpty(builder.getName().getFirstName())) {
      m_nameHelper.updateNamePb(builder.getName(),orgBuilder.getNameBuilder());
    }
    if (builder.getContactDetails().getSerializedSize() > 0){
        m_contactDetailsHelper.updateContactDetails(builder.getContactDetails(),orgBuilder.getContactDetailsBuilder());
    }
    return super.updater(orgBuilder.build());
  }
}
