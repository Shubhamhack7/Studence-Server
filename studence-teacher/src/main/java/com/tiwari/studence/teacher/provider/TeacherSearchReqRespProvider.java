package com.tiwari.studence.teacher.provider;

import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.teacher.TeacherSearchReqPb;
import com.tiwari.studence.proto.teacher.TeacherSearchRespPb;

import javax.inject.Singleton;

@Singleton
public class TeacherSearchReqRespProvider implements IReqRespPbBuilderProvider<TeacherSearchReqPb,TeacherSearchReqPb.Builder, TeacherSearchRespPb,TeacherSearchRespPb.Builder> {
  @Override
  public TeacherSearchReqPb.Builder getReqBuilder() {
    return TeacherSearchReqPb.newBuilder();
  }

  @Override
  public TeacherSearchReqPb.Builder getReqBuilder(TeacherSearchReqPb builder) {
    return TeacherSearchReqPb.newBuilder(builder);
  }

  @Override
  public TeacherSearchRespPb.Builder getRespBuilder() {
    return TeacherSearchRespPb.newBuilder();
  }

  @Override
  public TeacherSearchRespPb.Builder getRespBuilder(TeacherSearchRespPb builder) {
    return TeacherSearchRespPb.newBuilder(builder);
  }
}
