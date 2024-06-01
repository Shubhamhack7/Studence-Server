package com.tiwari.studence.teacher;

import com.google.inject.Injector;
import com.tiwari.studence.proto.teacher.TeacherPb;
import com.tiwari.studence.teacher.injector.InjectorProvider;
import com.tiwari.studence.teacher.service.ITeacherService;
import com.tiwari.studence.teacher.service.TeacherService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Injector inj = InjectorProvider.createInjector();
        ITeacherService service = inj.getInstance(TeacherService.class);
        TeacherPb.Builder pb = TeacherPb.newBuilder();
        pb.getNameBuilder().setFirstName("Ravi");
        pb.getNameBuilder().setLastName("Savant");
    }
}
