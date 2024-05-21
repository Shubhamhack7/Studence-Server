package com.tiwari.studence.server.organisationCreateAndCampus.service;

import com.tiwari.studence.common.services.interfaces.IHandleService;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateReqPb;
import com.tiwari.studence.proto.campus.OrganisationCreateAndCampusCreateRespPb;

public interface IOrganisationCreateAndCampusCreate extends
        IHandleService<OrganisationCreateAndCampusCreateReqPb, OrganisationCreateAndCampusCreateRespPb> {
}
