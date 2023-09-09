package com.tiwari.studence.classes.searcher;

import com.tiwari.studence.classes.converter.ClassesConverter;
import com.tiwari.studence.classes.indexer.ClassesIndexer;
import com.tiwari.studence.classes.provider.ClassesProvider;
import com.tiwari.studence.classes.provider.ClassesSearchReqRespProvider;
import com.tiwari.studence.classes.provider.ClassesTableNameProvider;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.proto.classes.ClassesPb;
import com.tiwari.studence.proto.classes.ClassesSearchReqPb;
import com.tiwari.studence.proto.classes.ClassesSearchRespPb;

import javax.inject.Inject;

public class ClassesSearcher extends
        AEntitySearcher<ClassesPb, ClassesPb.Builder, ClassesProvider, ClassesSearchReqPb, ClassesSearchReqPb.Builder, ClassesSearchRespPb, ClassesSearchRespPb.Builder, ClassesSearchReqRespProvider, ClassesConverter, ClassesIndexer, ClassesTableNameProvider> {
  @Inject
  public ClassesSearcher(ClassesConverter convertor, IDynamoSearchTable dyamodbSearchTable,
                         ClassesTableNameProvider tableNameProvider,
                         ClassesSearchReqRespProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }
}
