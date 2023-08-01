package com.tiwari.studence.login.service;

import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.proto.login.LoginPb;
import com.tiwari.studence.proto.login.LoginSearchReqPb;
import com.tiwari.studence.proto.login.LoginSearchRespPb;

public interface ILoginService extends
        IEntityService<LoginPb, LoginSearchReqPb, LoginSearchRespPb> {
}
