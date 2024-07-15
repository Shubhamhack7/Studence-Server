package com.tiwari.studence.campus.updater;

import com.tiwari.studence.campus.converter.CampusRefConvertor;
import com.tiwari.studence.campus.indexer.CampusIndexer;
import com.tiwari.studence.campus.provider.CampusProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.organisation.convertor.OrganisationRefConvertor;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.organisation.OrganisationRefPb;
import com.tiwari.studence.util.collect.Quadlets;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;

@Singleton
public class CampusUpdater
        extends AEntityUpdater<CampusPb, CampusPb.Builder, CampusProvider, CampusIndexer> {

  private IOrganisationService m_service;
  private OrganisationRefConvertor m_refconvertor;
  private NameHelper m_nameHelper;
  private ContactDetailsHelper m_contactDetailsHelper;

  @Inject
  public CampusUpdater(CampusIndexer indexer, CampusProvider builderProvider, NameHelper nameHelper,
          ContactDetailsHelper contactDetailsHelper, IOrganisationService service,
          OrganisationRefConvertor refconvertor) {
    super(indexer, builderProvider);
    m_refconvertor = refconvertor;
    m_service = service;
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
    if (Strings.notEmpty(builder.getOrganisationRef().getDbInfoId())) {
     // campusBuilder.setOrganisationRef(builder.getOrganisationRef());
      addRefintoList(m_service, m_refconvertor, campusBuilder.getOrganisationRefBuilder(),
              builder.getOrganisationRef().getDbInfoId());
    }
    if (Strings.notEmpty(builder.getCampusCode())) {
      campusBuilder.setCampusCode(builder.getCampusCode());
    }
    updateRef();
    return super.updater(campusBuilder.build());
  }
}
