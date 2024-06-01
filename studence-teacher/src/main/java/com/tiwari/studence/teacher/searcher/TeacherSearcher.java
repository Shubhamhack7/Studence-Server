package com.tiwari.studence.teacher.searcher;

import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.proto.teacher.TeacherPb;
import com.tiwari.studence.proto.teacher.TeacherSearchReqPb;
import com.tiwari.studence.proto.teacher.TeacherSearchRespPb;
import com.tiwari.studence.teacher.converter.TeacherConverter;
import com.tiwari.studence.teacher.indexer.TeacherIndexer;
import com.tiwari.studence.teacher.provider.TeacherProvider;
import com.tiwari.studence.teacher.provider.TeacherSearchReqRespProvider;
import com.tiwari.studence.teacher.provider.TeacherTableNameProvider;

import javax.inject.Inject;

public class TeacherSearcher extends
        AEntitySearcher<TeacherPb, TeacherPb.Builder, TeacherProvider, TeacherSearchReqPb, TeacherSearchReqPb.Builder, TeacherSearchRespPb, TeacherSearchRespPb.Builder, TeacherSearchReqRespProvider, TeacherConverter, TeacherIndexer, TeacherTableNameProvider> {
  @Inject
  public TeacherSearcher(TeacherConverter convertor, IDynamoSearchTable dyamodbSearchTable,
                         TeacherTableNameProvider tableNameProvider,
                         TeacherSearchReqRespProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }
}
