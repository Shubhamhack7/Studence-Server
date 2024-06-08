package com.tiwari.studence.classes.updater;

import com.tiwari.studence.classes.indexer.ClassesIndexer;
import com.tiwari.studence.classes.provider.ClassesProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.classes.ClassType;
import com.tiwari.studence.proto.classes.ClassesPb;
import com.tiwari.studence.proto.classes.SectionType;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.helper.GenericRefHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class ClassesUpdater
        extends AEntityUpdater<ClassesPb, ClassesPb.Builder, ClassesProvider, ClassesIndexer> {

  public GenericRefHelper m_genericRefHelper;

  @Inject
  public ClassesUpdater(ClassesIndexer indexer, ClassesProvider builderProvider,
          GenericRefHelper genericRefHelper) {
    super(indexer, builderProvider);
    m_genericRefHelper = genericRefHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(ClassesPb builder, EntityPb pb) {
    ClassesPb.Builder classBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(classBuilder.getDbInfoBuilder(), pb);
    if (builder.getClassType() != ClassType.CLASS_UNKNOWN) {
      classBuilder.setClassType(builder.getClassType());
    }
    if (builder.getSectionType() != SectionType.SECTION_UNKNOWN) {
      classBuilder.setSectionType(builder.getSectionType());
    }
    m_genericRefHelper.updateCampusAndOrganisationGenericRef(classBuilder.getCampusRefBuilder(),
            builder.getCampusRef());
    return super.updater(classBuilder.build());
  }
}
