package com.tiwari.studence.server.organisationCreateAndCampus.service;

import com.tiwari.studence.campus.service.ICampusService;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.organisation.service.IOrganisationService;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateRespPb;
import com.tiwari.studence.server.organisationCreateAndCampus.controlFlow.OrganisationCreateAndCampusCreateCF;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OrganisationCreateAndCampusCreateService implements IOrganisationCreateAndCampusCreate {
    private IOrganisationService m_organisationService;
    private ICampusService m_campusService;

    @Inject
    public OrganisationCreateAndCampusCreateService(IOrganisationService organisationService, ICampusService campusService) {
    m_campusService=campusService;
    m_organisationService=organisationService;
    }

    @Override
    public IFuture<OrganisationCreateAndCampusCreateRespPb, ErrorException> executeService(OrganisationCreateAndCampusCreateReqPb data) {
        OrganisationCreateAndCampusCreateCF cf = new OrganisationCreateAndCampusCreateCF(data,m_organisationService,m_campusService);
        cf.addLogObjects(data);
        cf.startAsyncCall();
        return cf.getFutureResult();
    }
}
