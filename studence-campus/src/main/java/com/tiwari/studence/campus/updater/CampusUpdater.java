package com.tiwari.studence.campus.updater;

import com.tiwari.studence.campus.indexer.CampusIndexer;
import com.tiwari.studence.campus.provider.CampusProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class CampusUpdater
        extends AEntityUpdater<CampusPb, CampusPb.Builder, CampusProvider, CampusIndexer> {

  private NameHelper m_nameHelper;
  private ContactDetailsHelper m_contactDetailsHelper;

  @Inject
  public CampusUpdater(CampusIndexer indexer, CampusProvider builderProvider, NameHelper nameHelper,
          ContactDetailsHelper contactDetailsHelper) {
    super(indexer, builderProvider);
    m_nameHelper = nameHelper;
    m_contactDetailsHelper = contactDetailsHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(CampusPb builder, EntityPb pb) {
    CampusPb.Builder campusBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(campusBuilder.getDbInfoBuilder(), pb);
    if (Strings.notEmpty(builder.getName().getFirstName())) {
      m_nameHelper.updateNamePb(builder.getName(), campusBuilder.getNameBuilder());
    }
    if (builder.getContactDetails().getSerializedSize() > 0) {
      m_contactDetailsHelper.updateContactDetails(builder.getContactDetails(),
              campusBuilder.getContactDetailsBuilder());
    }
    if (Strings.notEmpty(builder.getOrganisationRef().getDbInfoId())){
      campusBuilder.setOrganisationRef(builder.getOrganisationRef());
    }
    if (Strings.notEmpty(builder.getCampusCode())){
      campusBuilder.setCampusCode(builder.getCampusCode());
    }
    return super.updater(campusBuilder.build());
  }
}
