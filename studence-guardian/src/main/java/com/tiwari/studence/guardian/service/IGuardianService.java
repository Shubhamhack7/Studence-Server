package com.tiwari.studence.guardian.service;

import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.proto.guardian.GuardianPb;
import com.tiwari.studence.proto.guardian.GuardianSearchReqPb;
import com.tiwari.studence.proto.guardian.GuardianSearchRespPb;

public interface IGuardianService
        extends IEntityService<GuardianPb, GuardianSearchReqPb, GuardianSearchRespPb> {
}
