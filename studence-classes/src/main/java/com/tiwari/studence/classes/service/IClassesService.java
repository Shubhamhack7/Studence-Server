package com.tiwari.studence.classes.service;

import com.tiwari.studence.common.service.v1.services.interfaces.IEntityService;
import com.tiwari.studence.proto.classes.ClassesPb;
import com.tiwari.studence.proto.classes.ClassesSearchReqPb;
import com.tiwari.studence.proto.classes.ClassesSearchRespPb;

public interface IClassesService extends IEntityService<ClassesPb, ClassesSearchReqPb, ClassesSearchRespPb> {
}
