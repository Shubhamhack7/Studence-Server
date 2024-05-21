package com.tiwari.studence.typeAhed.service;

import com.tiwari.studence.common.service.v1.services.interfaces.IEntityService;
import com.tiwari.studence.proto.typeAhead.TypeAheadPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchReqPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchRespPb;

public interface ITypeAheadService
        extends IEntityService<TypeAheadPb, TypeAheadSearchReqPb, TypeAheadSearchRespPb> {
}
