package com.tiwari.studence.attendence.module;

import com.google.inject.AbstractModule;
import com.tiwari.studence.attendence.bquery.AttendenceBigQueryService;
import com.tiwari.studence.attendence.bquery.IAttendenceBigQueryService;
import com.tiwari.studence.attendence.service.AttendenceService;
import com.tiwari.studence.attendence.service.IAttendenceService;

public class AttendenceModule extends AbstractModule{

  @Override
  protected void configure() {
    bind(IAttendenceService.class).to(AttendenceService.class);
    bind(IAttendenceBigQueryService.class).to(AttendenceBigQueryService.class);
  }

}
