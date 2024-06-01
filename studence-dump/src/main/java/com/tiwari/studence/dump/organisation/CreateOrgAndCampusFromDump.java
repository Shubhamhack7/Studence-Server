package com.tiwari.studence.dump.organisation;

import com.tiwari.studence.campus.service.ICampusService;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.helper.EmailHelper;
import com.tiwari.studence.util.helper.NameHelper;
import org.apache.commons.csv.CSVRecord;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CreateOrgAndCampusFromDump {

  private IOrganisationService m_organisatonService;
  private ICampusService m_campusService;
  private NameHelper m_nameHelper;
  private EmailHelper m_emailHelper;

  @Inject
  public CreateOrgAndCampusFromDump(IOrganisationService organisatonService, NameHelper nameHelper,
          EmailHelper emailHelper, ICampusService campusService) {
    m_organisatonService = organisatonService;
    m_nameHelper = nameHelper;
    m_emailHelper = emailHelper;
    m_campusService = campusService;
  }

  public IFuture<String, ErrorException> createOrgAndCampusFromDump(CSVRecord record) {
    CreateOrgAndCampusForDumpCF cf = new CreateOrgAndCampusForDumpCF(m_organisatonService, record,
            m_nameHelper, m_emailHelper, m_campusService);
    cf.addLogObjects(record);
    cf.startAsyncCall();
    return cf.getFutureResult();
  }
}
