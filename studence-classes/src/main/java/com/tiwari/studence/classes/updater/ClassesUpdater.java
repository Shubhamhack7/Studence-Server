package com.tiwari.studence.classes.updater;

import com.tiwari.studence.classes.indexer.ClassesIndexer;
import com.tiwari.studence.classes.provider.ClassesProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.classes.ClassesPb;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.genericRef.GenericRefPbWithBoolean;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;

@Singleton
public class ClassesUpdater
        extends AEntityUpdater<ClassesPb, ClassesPb.Builder, ClassesProvider, ClassesIndexer> {

  private NameHelper m_nameHelper;
  private ContactDetailsHelper m_contactDetailsHelper;

  @Inject
  public ClassesUpdater(ClassesIndexer indexer, ClassesProvider builderProvider, NameHelper nameHelper,
                        ContactDetailsHelper contactDetailsHelper) {
    super(indexer, builderProvider);
    m_nameHelper = nameHelper;
    m_contactDetailsHelper = contactDetailsHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(ClassesPb builder, EntityPb pb) {
    ClassesPb.Builder classBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(classBuilder.getDbInfoBuilder(), pb);

    if (Strings.notEmpty(builder.getCampusRef().getDbInfoId())){
      classBuilder.setCampusRef(builder.getCampusRef());
    }
    if (Strings.notEmpty(builder.getClassType().)){
      classBuilder.setCampusRef(builder.getCampusRef());
    }
    List<GenericRefPbWithBoolean> teachersFromBuilder = builder.getOthersTeacherList();
    teachersFromBuilder.forEach(teacher -> classBuilder.addOthersTeacher(teacher));
    return super.updater(classBuilder.build());
  }
}
