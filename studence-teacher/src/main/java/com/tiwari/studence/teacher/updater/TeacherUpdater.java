package com.tiwari.studence.teacher.updater;

import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.datatypes.BooleanEnum;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.subject.SubjectTypeEnum;
import com.tiwari.studence.proto.teacher.TeacherClassPb;
import com.tiwari.studence.proto.teacher.TeacherClassSubjectPb;
import com.tiwari.studence.proto.teacher.TeacherPb;
import com.tiwari.studence.teacher.indexer.TeacherIndexer;
import com.tiwari.studence.teacher.provider.TeacherProvider;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class TeacherUpdater
        extends AEntityUpdater<TeacherPb, TeacherPb.Builder, TeacherProvider, TeacherIndexer> {

  private NameHelper m_nameHelper;
  private ContactDetailsHelper m_contactDetailsHelper;

  @Inject
  public TeacherUpdater(TeacherIndexer indexer, TeacherProvider builderProvider,
          NameHelper nameHelper, ContactDetailsHelper contactDetailsHelper) {
    super(indexer, builderProvider);
    m_nameHelper = nameHelper;
    m_contactDetailsHelper = contactDetailsHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(TeacherPb builder, EntityPb pb) {
    TeacherPb.Builder teacherBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(teacherBuilder.getDbInfoBuilder(), pb);
    if (Strings.notEmpty(builder.getName().getFirstName())) {
      m_nameHelper.updateNamePb(builder.getName(), teacherBuilder.getNameBuilder());
    }
    if (builder.getContactDetails().getSerializedSize() > 0) {
      m_contactDetailsHelper.updateContactDetails(builder.getContactDetails(),
              teacherBuilder.getContactDetailsBuilder());
    }
    updateClassTeacherAndTeacher(builder.getClassTeacherAndTeacher(),
            teacherBuilder.getClassTeacherAndTeacherBuilder());
    if (Strings.notEmpty(builder.getCampusRef().getDbInfoId())) {
      teacherBuilder.setCampusRef((builder.getCampusRef()));
    }

    return super.updater(teacherBuilder.build());
  }

  private void updateClassTeacherAndTeacher(TeacherClassPb classTeacherAndTeacher,
          TeacherClassPb.Builder classTeacherAndTeacherBuilder) {
    if (classTeacherAndTeacher.getIsCLassTeacher() == BooleanEnum.TRUE) {
      classTeacherAndTeacherBuilder.setIsCLassTeacher(BooleanEnum.TRUE);
      classTeacherAndTeacher.getClassTeacherList().forEach(teacherClassSubject -> {
        updateClassRefAndSubject(teacherClassSubject,
                classTeacherAndTeacherBuilder.addClassTeacherBuilder());
      });

    } else {
      classTeacherAndTeacherBuilder.setIsCLassTeacher(BooleanEnum.FALSE);
    }

    classTeacherAndTeacher.getTeacherList().forEach(teacherSubject -> {
      updateClassRefAndSubject(teacherSubject, classTeacherAndTeacherBuilder.addTeacherBuilder());
    });
  }

  private void updateClassRefAndSubject(TeacherClassSubjectPb classTeacher,
          TeacherClassSubjectPb.Builder classTeacherBuilder) {
    if (classTeacher.getSubjectType() != SubjectTypeEnum.UNKNOWN_SUBJECT) {
      classTeacherBuilder.setClassTeacher(classTeacher.getClassTeacher());
      classTeacherBuilder.setSubjectType(classTeacher.getSubjectType());
    }

  }
}
