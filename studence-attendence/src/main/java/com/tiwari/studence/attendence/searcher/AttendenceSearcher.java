package com.tiwari.studence.attendence.searcher;

import com.tiwari.studence.attendence.convertor.AttendenceConvertor;
import com.tiwari.studence.attendence.indexer.AttendenceIndexer;
import com.tiwari.studence.attendence.provider.AttendencePbProvider;
import com.tiwari.studence.attendence.provider.AttendenceSearchPbProvider;
import com.tiwari.studence.attendence.provider.AttendenceTableNameProvider;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.interfaces.IDynamoSearchTable;
import com.tiwari.studence.common.searcher.AEntitySearcher;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.proto.attendence.AttendenceSearchReqPb;
import com.tiwari.studence.proto.attendence.AttendenceSearchRespPb;
import com.tiwari.studence.proto.search.SearchRequestsPb;
import com.tiwari.studence.util.exception.ErrorException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AttendenceSearcher extends
        AEntitySearcher<AttendencePb, AttendencePb.Builder, AttendencePbProvider, AttendenceSearchReqPb,AttendenceSearchReqPb.Builder, AttendenceSearchRespPb, AttendenceSearchRespPb.Builder, AttendenceSearchPbProvider, AttendenceConvertor, AttendenceIndexer, AttendenceTableNameProvider> {

  @Inject
  public AttendenceSearcher(AttendenceConvertor convertor,
                            IDynamoSearchTable dyamodbSearchTable, AttendenceTableNameProvider tableNameProvider,
                            AttendenceSearchPbProvider responseBuilderProvider) {
    super(convertor, dyamodbSearchTable, tableNameProvider, responseBuilderProvider);
  }

  @Override
  public IFuture<AttendenceSearchRespPb, ErrorException> searcher(
          AttendenceSearchReqPb builder) {
    SearchRequestsPb.Builder requestBuilder = getSearchRequestBuilderProvider().getBuilder();
    //to be implemented
    /*if (Strings.notEmpty(builder.getName())) {
      SearchPb.Builder nameReq = requestBuilder.addRequestsBuilder();
      nameReq.setType(ComparisonOperatorEnum.EQUAL_TO);
      addEqualToValue(nameReq, DynamoDBValue.DYNAMODB_VALUE_STRING, builder.getName(),
              AttendenceIndexerEnum.ATTENDENCE_STUDENT_REF_NAME.name(), AttendenceIndexerEnum.ATTENDENCE_STUDENT_REF_NAME.isLowerCase());
    }*/
    return super.performsearcher(requestBuilder.build());
  }

}
