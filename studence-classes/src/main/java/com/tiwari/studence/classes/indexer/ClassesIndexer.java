package com.tiwari.studence.classes.indexer;

import com.tiwari.studence.common.indexer.AEntityIndexer;
import com.tiwari.studence.proto.classes.ClassesPb;
import com.tiwari.studence.util.encoder.JsonBaseEncoderDecoder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class ClassesIndexer extends AEntityIndexer<ClassesPb> {
  @Inject
  public ClassesIndexer(JsonBaseEncoderDecoder jsonBaseEncoderDecoder) {
    super(jsonBaseEncoderDecoder);
  }

  @Override
  public HashMap<String, AttributeValue> indexer(ClassesPb builder) {
    HashMap<String, AttributeValue> items = super.indexer(builder);
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_CAMPUS_REF_ID.name(),
            builder.getCampusRef().getDbInfoId(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_CAMPUS_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_CAMPUS_REF_NAME.name(),
            builder.getCampusRef().getName().toLowerCase(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_CAMPUS_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_CLASS_TYPE.getLabel(),
            builder.getClassType().toString().toLowerCase(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_CLASS_TYPE.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_SECTION_TYPE.getLabel(),
            builder.getSectionType().toString().toLowerCase(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_SECTION_TYPE.isLowerCase());
    /*addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_CAMPUS_REF_ORG_ID.name(),
            builder.getCampusRef().getOrganisationRef().getDbInfoId(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_CAMPUS_REF_ORG_ID.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_CAMPUS_REF_ORG_NAME.name(),
            builder.getCampusRef().getOrganisationRef().getName().toLowerCase(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_CAMPUS_REF_ORG_NAME.isLowerCase());*/
    /*addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_OTHER_TEACHER_REF_ID.name(),
            builder.getDbInfoId(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_OTHER_TEACHER_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_OTHER_TEACHER_REF_NAME.name(),
            builder.get.getName().toLowerCase(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_OTHER_TEACHER_REF_NAME.isLowerCase());*/
    return items;
  }
}
