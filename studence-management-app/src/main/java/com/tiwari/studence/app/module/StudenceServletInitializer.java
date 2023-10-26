package com.tiwari.studence.app.module;

import com.tiwari.studence.app.servlet.MyServlet;
import com.tiwari.studence.organisation.servlet.OrganisationServlet;
import com.tiwari.studence.pushNotification.servlet.PushNotificationServlet;
import com.tiwari.studence.server.organisationCreateAndCampus.servlet.OrganisationCreateAndCampusServlet;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

import java.util.Set;

public class StudenceServletInitializer implements ServletContainerInitializer {

  private ServletRegistration.Dynamic servletRegistration;

  @Override
  public void onStartup(Set<Class<?>> classes, ServletContext servletContext)
          throws ServletException {
    servletRegistration = servletContext.addServlet("myServlet", MyServlet.class);
    servletRegistration.addMapping("/");
    servletRegistration = servletContext.addServlet("pushNotification",
            PushNotificationServlet.class);
    servletRegistration.addMapping("/pushNotification");
    servletRegistration = servletContext.addServlet("organisation", OrganisationServlet.class);
    servletRegistration.addMapping("/organisation");
    servletRegistration = servletContext.addServlet("organisationAndCampusCreateService",
            OrganisationCreateAndCampusServlet.class);
    servletRegistration.addMapping("/organisationAndCampusCreateService");

  }

}
