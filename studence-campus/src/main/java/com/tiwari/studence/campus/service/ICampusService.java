package com.tiwari.studence.campus.service;

import com.tiwari.studence.common.service.v1.services.interfaces.IEntityService;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.campus.CampusSearchReqPb;
import com.tiwari.studence.proto.campus.CampusSearchRespPb;

public interface ICampusService extends IEntityService<CampusPb, CampusSearchReqPb, CampusSearchRespPb> {
}
