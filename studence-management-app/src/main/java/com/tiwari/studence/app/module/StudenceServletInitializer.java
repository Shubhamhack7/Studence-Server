package com.tiwari.studence.app.module;




import com.tiwari.studence.app.servlet.MyServlet;
import com.tiwari.studence.organisation.servlet.OrganisationServlet;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

import java.util.Set;

public class StudenceServletInitializer implements ServletContainerInitializer {

    private  ServletRegistration.Dynamic servletRegistration;

    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
        servletRegistration = servletContext.addServlet("myServlet", MyServlet.class);
        servletRegistration.addMapping("/");
        servletRegistration = servletContext.addServlet("organisation", OrganisationServlet.class);
        servletRegistration.addMapping("/organisation");

    }

}
