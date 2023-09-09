package com.tiwari.studence.attendence.indexer;

import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue.Type;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class AttendenceIndexer extends AEntityIndexer<AttendencePb> {

  @Inject
  public AttendenceIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(AttendencePb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, AttendenceIndexerEnum.ATTENDENCE_STUDENT_REF_ID.getLabel(), builder.getStudentRef().getDbInfoId(), false,
            Type.S, AttendenceIndexerEnum.ATTENDENCE_STUDENT_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, AttendenceIndexerEnum.ATTENDENCE_STUDENT_REF_NAME.getLabel(), builder.getStudentRef().getName(), false,
            Type.S, AttendenceIndexerEnum.ATTENDENCE_STUDENT_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, AttendenceIndexerEnum.ATTENDENCE_CLASS_REF_ID.getLabel(), builder.getClassRef().getDbInfoId(), false,
            Type.S, AttendenceIndexerEnum.ATTENDENCE_CLASS_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, AttendenceIndexerEnum.ATTENDENCE_CLASS_TYPE_REF.getLabel(), builder.getClassRef().getClassType().name(), false,
            Type.S, AttendenceIndexerEnum.ATTENDENCE_CLASS_TYPE_REF.isLowerCase());
    addItemToAttritibeMap(items, AttendenceIndexerEnum.ATTENDENCE_CLASS_SECTION_TYPE_REF.getLabel(), builder.getClassRef().getSectionType().name(), false,
            Type.S, AttendenceIndexerEnum.ATTENDENCE_CLASS_SECTION_TYPE_REF.isLowerCase());
    addItemToAttritibeMap(items, AttendenceIndexerEnum.ATTENDENCE_TEACHER_REF_ID.getLabel(), builder.getTeacherRef().getDbInfoId(), false,
            Type.S, AttendenceIndexerEnum.ATTENDENCE_TEACHER_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, AttendenceIndexerEnum.ATTENDENCE_TEACHER_REF_NAME.getLabel(), builder.getTeacherRef().getName(), false,
            Type.S, AttendenceIndexerEnum.ATTENDENCE_TEACHER_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, AttendenceIndexerEnum.ATTENDENCE_IS_PRESENT.getLabel(), builder.getIsPresent().name(), false,
            Type.S, AttendenceIndexerEnum.ATTENDENCE_IS_PRESENT.isLowerCase());

    return items;
  }

}
