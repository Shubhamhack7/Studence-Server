package com.tiwari.studence.classes.provider;


import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.proto.classes.ClassesSearchReqPb;
import com.tiwari.studence.proto.classes.ClassesSearchRespPb;

import javax.inject.Singleton;

@Singleton
public class ClassesSearchReqRespProvider implements IReqRespPbBuilderProvider<ClassesSearchReqPb,ClassesSearchReqPb.Builder, ClassesSearchRespPb, ClassesSearchRespPb.Builder> {
  @Override
  public ClassesSearchReqPb.Builder getReqBuilder() {
    return ClassesSearchReqPb.newBuilder();
  }

  @Override
  public ClassesSearchReqPb.Builder getReqBuilder(ClassesSearchReqPb builder) {
    return ClassesSearchReqPb.newBuilder(builder);
  }

  @Override
  public ClassesSearchRespPb.Builder getRespBuilder() {
    return ClassesSearchRespPb.newBuilder();
  }

  @Override
  public ClassesSearchRespPb.Builder getRespBuilder(ClassesSearchRespPb builder) {
    return ClassesSearchRespPb.newBuilder(builder);
  }
}
