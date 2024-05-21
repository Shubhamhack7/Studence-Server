package com.tiwari.studence.teacher.provider;

import com.tiwari.studence.common.providerInterfaces.IPbBuilderProvider;
import com.tiwari.studence.proto.teacher.TeacherPb;

import javax.inject.Singleton;

@Singleton
public class TeacherProvider implements IPbBuilderProvider<TeacherPb, TeacherPb.Builder> {
  @Override
  public TeacherPb.Builder getBuilder() {
    return TeacherPb.newBuilder();
  }

  @Override
  public TeacherPb.Builder getBuilder(TeacherPb builder) {
    return TeacherPb.newBuilder(builder);
  }
}
