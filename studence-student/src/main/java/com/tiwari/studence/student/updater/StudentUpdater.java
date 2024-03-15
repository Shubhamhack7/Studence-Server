package com.tiwari.studence.student.updater;

import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.proto.student.StudentPb;
import com.tiwari.studence.student.indexer.StudentIndexer;
import com.tiwari.studence.student.provider.StudentProvider;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class StudentUpdater
        extends AEntityUpdater<StudentPb, StudentPb.Builder, StudentProvider, StudentIndexer> {

  private NameHelper m_nameHelper;
  private ContactDetailsHelper m_contactDetailsHelper;

  @Inject
  public StudentUpdater(StudentIndexer indexer, StudentProvider builderProvider, NameHelper nameHelper,
                        ContactDetailsHelper contactDetailsHelper) {
    super(indexer, builderProvider);
    m_nameHelper = nameHelper;
    m_contactDetailsHelper = contactDetailsHelper;
  }

  @Override
  public HashMap<String, AttributeValue> updater(StudentPb builder, EntityPb pb) {
    StudentPb.Builder studentBuilder = getBuilderProvider().getBuilder();
    updateEntityBuilder(studentBuilder.getDbInfoBuilder(), pb);
    if(Strings.notEmpty(builder.getName().getFirstName())){
      m_nameHelper.updateNamePb(builder.getName(), studentBuilder.getNameBuilder());
    }
    if(Strings.notEmpty(builder.getClassRef().getDbInfoId())){
      studentBuilder.setClassRef((builder.getClassRef()));
    }
    if(Strings.notEmpty(builder.getCampusRef().getDbInfoId())){
      studentBuilder.setCampusRef((builder.getCampusRef()));
    }
    if(Strings.notEmpty(builder.getClassRollNo())){
      studentBuilder.setClassRollNo(builder.getClassRollNo());
    }
    if(Strings.notEmpty(builder.getSerialOrRegistrationNo())){
      studentBuilder.setSerialOrRegistrationNo(builder.getSerialOrRegistrationNo());
    }
    if(Strings.notEmpty(builder.getParentRef().getDbInfoId())){
      studentBuilder.setParentRef(builder.getParentRef());
    }
    return super.updater(studentBuilder.build());
  }
}
