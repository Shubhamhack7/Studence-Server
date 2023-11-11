package com.tiwari.studence.attendence.updater;

import com.tiwari.studence.attendence.indexer.AttendenceIndexer;
import com.tiwari.studence.attendence.provider.AttendencePbProvider;
import com.tiwari.studence.common.updater.AEntityUpdater;
import com.tiwari.studence.proto.attendence.AttendencePb;
import com.tiwari.studence.proto.attendence.AttendencePb.Builder;
import com.tiwari.studence.proto.datatypes.BooleanEnum;
import com.tiwari.studence.proto.entity.EntityPb;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.helper.ContactDetailsHelper;
import com.tiwari.studence.util.helper.NameHelper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import javax.inject.Inject;
import java.util.HashMap;

public class AttendenceUpdater extends
        AEntityUpdater<AttendencePb, AttendencePb.Builder, AttendencePbProvider, AttendenceIndexer> {
    private NameHelper m_nameHelper;
    private ContactDetailsHelper m_contactDetailsHelper;

    @Inject
    public AttendenceUpdater(AttendenceIndexer indexer, AttendencePbProvider builderProvider, NameHelper nameHelper, ContactDetailsHelper contactDetailsHelper) {
        super(indexer, builderProvider);
        // TODO Auto-generated constructor stub
        m_nameHelper = nameHelper;
        m_contactDetailsHelper = contactDetailsHelper;
    }

    @Override
    public HashMap<String, AttributeValue> updater(AttendencePb builder, EntityPb pb) {
        Builder attendeceBuilder = getBuilderProvider().getBuilder();
        updateEntityBuilder(attendeceBuilder.getDbInfoBuilder(), pb);
        if (Strings.notEmpty(builder.getName().getFirstName())) {
            m_nameHelper.updateNamePb(builder.getName(), attendeceBuilder.getNameBuilder());
        }
        if (Strings.notEmpty(builder.getStudentRef().getDbInfoId())) {
            attendeceBuilder.setStudentRef(builder.getStudentRef());
        }
        if (Strings.notEmpty(builder.getTeacherRef().getDbInfoId())) {
            attendeceBuilder.setTeacherRef(builder.getTeacherRef());
        }
        if (Strings.notEmpty(builder.getClassRef().getDbInfoId())){
            attendeceBuilder.setClassRef(builder.getClassRef());
        }
        if(builder.getIsPresent()!=BooleanEnum.FALSE){
            attendeceBuilder.setIsPresent(builder.getIsPresent());
        }

        return super.updater(attendeceBuilder.build());
    }
}
