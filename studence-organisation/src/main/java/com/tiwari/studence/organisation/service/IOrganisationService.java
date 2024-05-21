package com.tiwari.studence.organisation.service;

import com.tiwari.studence.common.service.v1.services.interfaces.IEntityService;
import com.tiwari.studence.proto.organisation.OrganisationPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchReqPb;
import com.tiwari.studence.proto.organisation.OrganisationSearchRespPb;

public interface IOrganisationService
        extends IEntityService<OrganisationPb, OrganisationSearchReqPb, OrganisationSearchRespPb> {

}