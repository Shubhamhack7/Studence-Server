package com.tiwari.studence.typeAhed.searcher;

import com.tiwari.studence.common.convertor.AEntityConvertor;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.common.services.interfaces.ITableNameProvider;
import com.tiwari.studence.proto.typeAhead.TypeAheadPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchReqPb;
import com.tiwari.studence.proto.typeAhead.TypeAheadSearchRespPb;
import com.tiwari.studence.typeAhed.convertor.TypeAhedConvertor;
import com.tiwari.studence.typeAhed.indexer.TypeAhedIndexer;
import com.tiwari.studence.typeAhed.provider.TypeAheadSearchReqRespProvider;
import com.tiwari.studence.typeAhed.provider.TypeAheadTableNameProvider;
import com.tiwari.studence.typeAhed.provider.TypeAhedProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TypeAhedSearcher extends
        AEntitySearcher<TypeAheadPb, TypeAheadPb.Builder, TypeAhedProvider, TypeAheadSearchReqPb, TypeAheadSearchReqPb.Builder, TypeAheadSearchRespPb, TypeAheadSearchRespPb.Builder, TypeAheadSearchReqRespProvider, TypeAhedConvertor, TypeAhedIndexer, TypeAheadTableNameProvider> {

  @Inject
  public TypeAhedSearcher(TypeAhedConvertor convertor, IDynamoSearchTable dyamodbSearchTable,
          TypeAheadTableNameProvider tableNameProvider,
          TypeAheadSearchReqRespProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }
}
