package com.tiwari.studence.classes;

import com.google.inject.Injector;
import com.tiwari.studence.classes.injector.InjectorProvider;
import com.tiwari.studence.classes.service.IClassesService;
import com.tiwari.studence.proto.classes.ClassType;
import com.tiwari.studence.proto.classes.ClassesPb;
import com.tiwari.studence.proto.classes.SectionType;
import com.tiwari.studence.util.exception.ErrorException;

public class ClassesTestMain {
  public static void main(String[] args) throws ErrorException {
    Injector inj = InjectorProvider.createInjector();
    IClassesService service  = inj.getInstance(IClassesService.class);

    ClassesPb.Builder builder = ClassesPb.newBuilder();
    builder.setClassType(ClassType.CLASS_FIVE);
    builder.setSectionType(SectionType.SECTION_A);
    builder.getCampusRefBuilder().getOrganistionRefBuilder().setDbInfoId("abc123");
    builder.getCampusRefBuilder().getOrganistionRefBuilder().setName("abc123");
    builder.getCampusRefBuilder().setCampusDbInfoId("123");
    builder.getCampusRefBuilder().setCampusName("abc");
    ClassesPb a = service.create(builder.build()).get();
    System.out.println(a);
  }
}
