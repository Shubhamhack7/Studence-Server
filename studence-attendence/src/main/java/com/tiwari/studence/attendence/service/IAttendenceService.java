package com.tiwari.studence.attendence.service;

import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.proto.attendence.AttendenceSearchReqPb;
import com.tiwari.studence.proto.attendence.AttendenceSearchRespPb;

public interface IAttendenceService
        extends IEntityService<AttendencePb, AttendenceSearchReqPb, AttendenceSearchRespPb> {

}