package com.tiwari.studence.student.provider;

import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.proto.campus.CampusPb;
import com.tiwari.studence.proto.student.StudentPb;

import javax.inject.Singleton;

@Singleton
public class StudentProvider implements IPbBuilderProvider<StudentPb,StudentPb.Builder> {
  @Override
  public StudentPb.Builder getBuilder() {
    return StudentPb.newBuilder();
  }

  @Override
  public StudentPb.Builder getBuilder(StudentPb builder) {
    return StudentPb.newBuilder(builder);
  }
}
