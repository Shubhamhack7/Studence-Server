package com.tiwari.studence.app.listener;

import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@Singleton
public class StudenceServletListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletReq) {
        System.out.print("requestDestroyed");
        int a = servletReq.getServletRequest().getContentLength();
        HttpServletRequest request = (HttpServletRequest)servletReq.getServletRequest();
        if (!request.getServletPath().equals("/counter")) {
            ServletContext context = servletReq.getServletContext();
            context.setAttribute("counter", (int) context.getAttribute("counter") + 1);
            System.out.print("Hello World");
        }else {
            System.out.print("Else Hello World");
        }

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletReq) {
        System.out.print("requestInitialized");
        int a = servletReq.getServletRequest().getContentLength();
        HttpServletRequest request = (HttpServletRequest)servletReq.getServletRequest();
        if (!request.getServletPath().equals("/counter")) {
            ServletContext context = servletReq.getServletContext();
            context.setAttribute("counter", (int) context.getAttribute("counter") + 1);
            System.out.print("Hello World 2");
        }else {
            System.out.print("Else Hello World 2");
        }

    }
}
