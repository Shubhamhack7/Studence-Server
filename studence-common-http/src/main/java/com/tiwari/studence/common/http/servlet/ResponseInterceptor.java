package com.tiwari.studence.common.http.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Singleton
public class ResponseInterceptor {

  @Inject
  public ResponseInterceptor(){

  }

  /**
   * This will be called only for successful response
   */
  public Object getResponse(HttpServletRequest req, HttpServletResponse resp,
                            Object originalResponse) {
    return originalResponse;
  }

}