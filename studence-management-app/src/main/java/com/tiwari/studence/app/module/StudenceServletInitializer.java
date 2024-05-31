package com.tiwari.studence.app.module;

import com.tiwari.studence.app.servlet.MyServlet;
import com.tiwari.studence.campus.servlet.CampusServlet;
import com.tiwari.studence.login.servlet.LoginServlet;
import com.tiwari.studence.organisation.servlet.OrganisationServlet;
import com.tiwari.studence.server.createLogin.servlet.CreateLoginServlet;
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
  //  servletRegistration = servletContext.addServlet("pushNotification",
           // PushNotificationServlet.class);
    servletRegistration.addMapping("/pushNotification");
    servletRegistration = servletContext.addServlet("organisation", OrganisationServlet.class);
    servletRegistration.addMapping("/organisation");
    servletRegistration = servletContext.addServlet("createLogin", CreateLoginServlet.class);
    servletRegistration.addMapping("/createLogin");
    servletRegistration = servletContext.addServlet("login", LoginServlet.class);
    servletRegistration.addMapping("/login");
    servletRegistration = servletContext.addServlet("campus", CampusServlet.class);
    servletRegistration.addMapping("/campus");
   // servletRegistration = servletContext.addServlet("typeAhead",
          //  TypeAhedServlet.class);
    servletRegistration.addMapping("/typeAhead");
    servletRegistration = servletContext.addServlet("organisationAndCampusCreateService",
            OrganisationCreateAndCampusServlet.class);
    servletRegistration.addMapping("/organisationAndCampusCreateService");

  }

}
