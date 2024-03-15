package com.tiwari.studence.teacher.indexer;

import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.proto.teacher.TeacherPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class TeacherIndexer extends AEntityIndexer<TeacherPb> {
  @Inject
  public TeacherIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(TeacherPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, TeacherIndexerEnum.TEACHER_NAME.getLabel(),
            builder.getName().getCanonicalName(), false, AttributeValue.Type.S,
            TeacherIndexerEnum.TEACHER_NAME.isLowerCase());
    addItemToAttritibeMap(items, TeacherIndexerEnum.TEACHER_MOBILE.name(),
            builder.getContactDetails().getMobileNumbers().getPrimary().getCanonicalNumber()
                    .toLowerCase(), false, AttributeValue.Type.S,
            TeacherIndexerEnum.TEACHER_MOBILE.isLowerCase());
    addItemToAttritibeMap(items, TeacherIndexerEnum.TEACHER_EMAIL.name(),
            builder.getContactDetails().getEmails().getPrimary().getCanonicalEmail().toLowerCase(),
            false, AttributeValue.Type.S, TeacherIndexerEnum.TEACHER_EMAIL.isLowerCase());
    addItemToAttritibeMap(items, TeacherIndexerEnum.TEACHER_ADDRESS.name(),
            builder.getContactDetails().getAddress().getPrimary().getCanonicalAddress()
                    .toLowerCase(), false, AttributeValue.Type.S,
            TeacherIndexerEnum.TEACHER_ADDRESS.isLowerCase());
    addItemToAttritibeMap(items, TeacherIndexerEnum.TEACHER_CAMPUS_REF_ID.name(),
            builder.getCampusRef().getDbInfoId(), false, AttributeValue.Type.S,
            TeacherIndexerEnum.TEACHER_CAMPUS_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, TeacherIndexerEnum.TEACHER_CAMPUS_REF_NAME.name(),
            builder.getCampusRef().getName(), false, AttributeValue.Type.S,
            TeacherIndexerEnum.TEACHER_CAMPUS_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, TeacherIndexerEnum.TEACHER_CAMPUS_REF_ORG_ID.name(),
            builder.getCampusRef().getOrganisationRef().getDbInfoId(), false, AttributeValue.Type.S,
            TeacherIndexerEnum.TEACHER_CAMPUS_REF_ORG_ID.isLowerCase());
    addItemToAttritibeMap(items, TeacherIndexerEnum.TEACHER_CAMPUS_REF_ORG_NAME.name(),
            builder.getCampusRef().getOrganisationRef().getName().toLowerCase(), false,
            AttributeValue.Type.S, TeacherIndexerEnum.TEACHER_CAMPUS_REF_ORG_NAME.isLowerCase());
    addItemToAttritibeMap(items, TeacherIndexerEnum.TEACHER_IS_CLASS_TEACHER.getLabel(),
            builder.getClassTeacherAndTeacher().getIsCLassTeacher().name(), false,
            AttributeValue.Type.S, TeacherIndexerEnum.TEACHER_IS_CLASS_TEACHER.isLowerCase());

    return items;
  }
}
