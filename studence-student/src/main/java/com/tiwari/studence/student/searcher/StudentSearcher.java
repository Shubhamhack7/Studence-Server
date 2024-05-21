package com.tiwari.studence.student.searcher;

import com.tiwari.studence.campus.converter.CampusConverter;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.proto.student.StudentPb;
import com.tiwari.studence.proto.student.StudentSearchReqPb;
import com.tiwari.studence.proto.student.StudentSearchRespPb;
import com.tiwari.studence.student.converter.StudentConverter;
import com.tiwari.studence.student.indexer.StudentIndexer;
import com.tiwari.studence.student.provider.StudentProvider;
import com.tiwari.studence.student.provider.StudentSearchReqRespProvider;
import com.tiwari.studence.student.provider.StudentTableNameProvider;

import javax.inject.Inject;

public class StudentSearcher extends
        AEntitySearcher<StudentPb, StudentPb.Builder, StudentProvider, StudentSearchReqPb, StudentSearchReqPb.Builder, StudentSearchRespPb, StudentSearchRespPb.Builder, StudentSearchReqRespProvider, StudentConverter, StudentIndexer, StudentTableNameProvider> {
  @Inject
  public StudentSearcher(StudentConverter convertor, IDynamoSearchTable dyamodbSearchTable,
                         StudentTableNameProvider tableNameProvider,
                         StudentSearchReqRespProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }
}
