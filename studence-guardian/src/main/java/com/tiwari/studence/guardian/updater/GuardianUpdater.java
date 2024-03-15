package com.tiwari.studence.guardian.updater;

import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.guardian.indexer.GuardianIndexer;
import com.tiwari.studence.guardian.provider.GuardianPbProvider;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.guardian.GuardianPb;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class GuardianUpdater extends
        AEntityUpdater<GuardianPb, GuardianPb.Builder, GuardianPbProvider, GuardianIndexer> {

  private NameHelper m_nameHelper;
  private ContactDetailsHelper m_contactDetailsHelper;

  @Inject
  public GuardianUpdater(GuardianIndexer indexer, GuardianPbProvider builderProvider,
          NameHelper nameHelper, ContactDetailsHelper contactDetailsHelper) {
    super(indexer, builderProvider);
    m_nameHelper = nameHelper;
    m_contactDetailsHelper = contactDetailsHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(GuardianPb builder, EntityPb pb) {
    GuardianPb.Builder guardianBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(guardianBuilder.getDbInfoBuilder(), pb);
    if (Strings.notEmpty(builder.getFatherName().getFirstName())) {
      m_nameHelper.updateNamePb(builder.getFatherName(), guardianBuilder.getFatherNameBuilder());
    }
    if (Strings.notEmpty(builder.getMotherName().getFirstName())) {
      m_nameHelper.updateNamePb(builder.getMotherName(), guardianBuilder.getMotherNameBuilder());
    }
    guardianBuilder.setNoOfChildern(builder.getNoOfChildern());
    if (builder.getContactDetails().getSerializedSize() > 0) {
      m_contactDetailsHelper.updateContactDetails(builder.getContactDetails(),
              guardianBuilder.getContactDetailsBuilder());
    }
    return super.updater(builder, pb);
  }
}
