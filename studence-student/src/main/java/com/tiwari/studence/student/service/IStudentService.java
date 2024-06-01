package com.tiwari.studence.student.service;

import com.tiwari.studence.common.services.interfaces.IEntityService;
import com.tiwari.studence.proto.student.StudentPb;
import com.tiwari.studence.proto.student.StudentSearchReqPb;
import com.tiwari.studence.proto.student.StudentSearchRespPb;

public interface IStudentService extends IEntityService<StudentPb, StudentSearchReqPb, StudentSearchRespPb> {
}
