package com.tiwari.studence.student.provider;

import com.tiwari.studence.common.providerInterfaces.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.student.StudentSearchReqPb;
import com.tiwari.studence.proto.student.StudentSearchRespPb;

import javax.inject.Singleton;

@Singleton
public class StudentSearchReqRespProvider implements IReqRespPbBuilderProvider<StudentSearchReqPb,StudentSearchReqPb.Builder, StudentSearchRespPb,StudentSearchRespPb.Builder> {
  @Override
  public StudentSearchReqPb.Builder getReqBuilder() {
    return StudentSearchReqPb.newBuilder();
  }

  @Override
  public StudentSearchReqPb.Builder getReqBuilder(StudentSearchReqPb builder) {
    return StudentSearchReqPb.newBuilder(builder);
  }

  @Override
  public StudentSearchRespPb.Builder getRespBuilder() {
    return StudentSearchRespPb.newBuilder();
  }

  @Override
  public StudentSearchRespPb.Builder getRespBuilder(StudentSearchRespPb builder) {
    return StudentSearchRespPb.newBuilder(builder);
  }
}
