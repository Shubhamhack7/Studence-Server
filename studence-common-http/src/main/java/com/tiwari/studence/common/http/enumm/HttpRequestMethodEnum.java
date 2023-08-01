package com.tiwari.studence.common.http.enumm;

public enum HttpRequestMethodEnum {
	  DELETE("DELETE"),
	  HEAD("HEAD"),
	  GET("GET"),
	  OPTIONS("OPTIONS"),
	  POST("POST"),
	  PUT("PUT"),
	  TRACE("TRACE");

	  private final String m_methodName;

	  private HttpRequestMethodEnum(String methodName) {
	    m_methodName = methodName;
	  }

	  public static final HttpRequestMethodEnum getHttpRequestMethodEnum(String name) {
	    return HttpRequestMethodEnum.valueOf(name);
	  }
	}