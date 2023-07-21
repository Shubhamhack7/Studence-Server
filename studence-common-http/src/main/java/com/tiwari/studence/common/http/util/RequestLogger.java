package com.tiwari.studence.common.http.util;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Logger;

public class RequestLogger {

  private static final Logger LOGGER = Logger.getLogger(RequestLogger.class.getCanonicalName());

  public static void logRequest(HttpServletRequest req) {
    LOGGER.info("******** HTTP REQUEST *********");
    LOGGER.info("The Request QueryString: " + req.getQueryString());
    LOGGER.info("The Request RemoteAddr: " + req.getRemoteAddr());
    LOGGER.info("The RequestURL: " + req.getRequestURL());
    LOGGER.info("The Request URI: " + req.getRequestURI());
    LOGGER.info("The Request Method: " + req.getMethod());
    LOGGER.info("The Request Protocol: " + req.getProtocol());
    LOGGER.info("The Request Scheme: " + req.getScheme());
    LOGGER.info("The Request Character Encoding: " + req.getCharacterEncoding());
    LOGGER.info("The Request Content Length: " + req.getContentLength());
    LOGGER.info("The Request Content Type: " + req.getContentType());
    LOGGER.info("The Request Locale: " + req.getLocale());
    LOGGER.info("The Request Servlet Path: " + req.getServletPath());
    LOGGER.info("The Request Context Path: " + req.getContextPath());
    LOGGER.info("The Request Auth Type: " + req.getAuthType());
    LOGGER.info("The Request Path Info: " + req.getPathInfo());
    LOGGER.info("The Request Path Translated: " + req.getPathTranslated());
    LOGGER.info("The Request Session ID: " + req.getRequestedSessionId());
    LOGGER.info("The Request Is Secure: " + req.isSecure());
    LOGGER.info("The Request Is Async Started: " + req.isAsyncStarted());
    LOGGER.info("The Request Is Async Supported: " + req.isAsyncSupported());
    LOGGER.info("The Request Is Dispatcher Type: " + req.getDispatcherType());
    LOGGER.info(
            "The Request Is Requested Session ID From Cookie: " + req.isRequestedSessionIdFromCookie());
    LOGGER.info(
            "The Request Is Requested Session ID From URL: " + req.isRequestedSessionIdFromURL());
    LOGGER.info("The Request Is Requested Session ID Valid: " + req.isRequestedSessionIdValid());
    LOGGER.info("The Request Is Requested Session ID Valid: " + req.isUserInRole(
            "ROLE_NAME")); // Replace "ROLE_NAME" with the desired role name for checking user role.

    // Log request headers
    LOGGER.info("******** REQUEST HEADERS *********");
    Enumeration<String> headerNames = req.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      LOGGER.info(headerName + ": " + req.getHeader(headerName));
    }

    // Log request parameters
    LOGGER.info("******** REQUEST PARAMETERS *********");
    Map<String, String[]> parameterMap = req.getParameterMap();
    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
      String paramName = entry.getKey();
      String[] paramValues = entry.getValue();
      LOGGER.info(paramName + ": " + Arrays.toString(paramValues));
    }

    LOGGER.info("***********************************");
  }
}
