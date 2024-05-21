package com.tiwari.studence.teacher.service;

import com.tiwari.studence.common.service.v1.services.interfaces.IEntityService;
import com.tiwari.studence.proto.teacher.TeacherPb;
import com.tiwari.studence.proto.teacher.TeacherSearchReqPb;
import com.tiwari.studence.proto.teacher.TeacherSearchRespPb;

public interface ITeacherService extends IEntityService<TeacherPb, TeacherSearchReqPb, TeacherSearchRespPb> {
}
