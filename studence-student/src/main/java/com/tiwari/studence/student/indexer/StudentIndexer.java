package com.tiwari.studence.student.indexer;

import com.tiwari.studence.common.service.v1.indexer.AEntityIndexer;
import com.tiwari.studence.proto.student.StudentPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class StudentIndexer extends AEntityIndexer<StudentPb> {
  @Inject
  public StudentIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(StudentPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_CLASS_REF_ID.name(),
            builder.getClassRef().getDbInfoId(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_CLASS_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_CLASS_TYPE_REF.name(),
            builder.getClassRef().getClassType().name(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_CLASS_TYPE_REF.isLowerCase());
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_CLASS_SECTION_TYPE_REF.name(),
            builder.getClassRef().getSectionType().name(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_CLASS_SECTION_TYPE_REF.isLowerCase());
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_CAMPUS_REF_ID.name(),
            builder.getCampusRef().getDbInfoId(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_CAMPUS_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_CAMPUS_REF_NAME.name(),
            builder.getCampusRef().getName(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_CAMPUS_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_CAMPUS_REF_ORG_ID.name(),
            builder.getCampusRef().getOrganisationRef().getDbInfoId(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_CAMPUS_REF_ORG_ID.isLowerCase());
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_CAMPUS_REF_ORG_NAME.name(),
            builder.getCampusRef().getOrganisationRef().getName(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_CAMPUS_REF_ORG_NAME.isLowerCase());
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_PARENT_REF_ID.name(),
            builder.getParentRef().getDbInfoId(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_PARENT_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_PARENT_REF_FATHER_NAME.name(),
            builder.getParentRef().getFatherName(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_PARENT_REF_FATHER_NAME.isLowerCase());
    addItemToAttritibeMap(items, StudentIndexerEnum.STUDENT_PARENT_REF_MOTHER_NAME.name(),
            builder.getParentRef().getMotherName(), false, AttributeValue.Type.S,
            StudentIndexerEnum.STUDENT_PARENT_REF_MOTHER_NAME.isLowerCase());
    return items;
  }
}
