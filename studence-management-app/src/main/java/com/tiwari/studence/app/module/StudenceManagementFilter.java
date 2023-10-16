package com.tiwari.studence.app.module;

import com.google.inject.Injector;


import com.tiwari.studence.common.injector.StaticInjectorProvider;
import com.tiwari.studence.firebase.initializer.FirebaseInitializer;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.inject.Inject;
import java.io.IOException;
import java.util.*;

public class  StudenceManagementFilter implements Filter {


    private Injector injector;
    private ServletContext servletContext;
    StudenceServletInitializer initializer;
    @Inject
    public StudenceManagementFilter(){

    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
        FirebaseInitializer.init();
        initializer = new StudenceServletInitializer();
        initializer.onStartup(null,servletContext);
        injector = (Injector) servletContext.getAttribute(Injector.class.getName());

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Set CORS headers
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        String servletPath = ((HttpServletRequest) request).getServletPath();
        servletPath = servletPath.substring(0, servletPath.lastIndexOf("/"));
        // Get the servlet registration from the servlet context
        ServletRegistration registration = null;
        Map<String, ? extends ServletRegistration> servletRegistrations = servletContext.getServletRegistrations();
        for (ServletRegistration servletRegistration : servletRegistrations.values()) {
            Collection<String> mappings = servletRegistration.getMappings();
            if (mappings.contains(servletPath)) {
                registration = servletRegistration;
                break;
            }
        }

        if (registration != null) {
            // Get the fully qualified class name of the servlet
            String servletClassName = registration.getClassName();

            try {
                // Instantiate the servlet using the class name
                Class<?> clazz = Class.forName(servletClassName);
                Servlet servlet =(Servlet)StaticInjectorProvider.getInjector().getInstance(clazz);
               // Method servletmethod = clazz.getMethod("createInstance");
              //  Servlet servlet =(Servlet) servletmethod.invoke(null);
                // Initialize the servlet
                servlet.init(new StandardServletConfig(servletContext, registration.getName(), new HashMap<>()));

                // Invoke the servlet
                servlet.service(request, httpResponse);

                // Destroy the servlet
                servlet.destroy();
            } catch (Exception e) {
                throw new ServletException(e);
            }
        } else {
            // The requested URL does not map to a servlet
            filterChain.doFilter(request, httpResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    private static class StandardServletConfig implements ServletConfig {
        private final ServletContext servletContext;
        private final String servletName;
        private final Map<String, String> initParameters;

        public StandardServletConfig(ServletContext servletContext, String servletName, Map<String, String> initParameters) {
            this.servletContext = servletContext;
            this.servletName = servletName;
            this.initParameters = initParameters;
        }

        @Override
        public String getServletName() {
            return servletName;
        }

        @Override
        public ServletContext getServletContext() {
            return servletContext;
        }

        @Override
        public String getInitParameter(String name) {
            return initParameters.get(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return Collections.enumeration(initParameters.keySet());
        }
    }
}
