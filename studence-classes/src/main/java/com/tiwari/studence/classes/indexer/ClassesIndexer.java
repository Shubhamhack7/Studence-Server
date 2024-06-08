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
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_CLASS_TYPE.name(),
            builder.getClassType().name(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_CLASS_TYPE.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_SECTION_TYPE.name(),
            builder.getSectionType().name(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_SECTION_TYPE.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_CAMPUS_REF_ID.name(),
            builder.getCampusRef().getCampusDbInfoId(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_CAMPUS_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_CAMPUS_REF_NAME.name(),
            builder.getCampusRef().getCampusName(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_CAMPUS_REF_NAME.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_ORGANISATION_REF_ID.name(),
            builder.getCampusRef().getOrganistionRef().getDbInfoId(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_ORGANISATION_REF_ID.isLowerCase());
    addItemToAttritibeMap(items, ClassesIndexerEnum.CLASSES_ORGANISATION_REF_NAME.name(),
            builder.getCampusRef().getOrganistionRef().getName(), false, AttributeValue.Type.S,
            ClassesIndexerEnum.CLASSES_ORGANISATION_REF_NAME.isLowerCase());
    return items;
  }
}
