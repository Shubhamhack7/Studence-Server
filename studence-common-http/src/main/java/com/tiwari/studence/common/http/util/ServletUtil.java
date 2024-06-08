package com.tiwari.studence.common.http.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.logging.Logger;

import com.tiwari.studence.common.http.servlet.BaseHttpServlet;
import com.tiwari.studence.util.exception.Exceptions;
import jakarta.servlet.http.HttpServletRequest;

public class ServletUtil {
	  private static final Logger LOGGER = Logger.getLogger(ServletUtil.class.getCanonicalName());

	  public static String extractIdFromPathInfo(String pathInfo) {
	    int len = pathInfo.length();
		int index = pathInfo.lastIndexOf('/');
		String substring = pathInfo.substring(index + 1,len);
		return substring;
	   // return pathInfo.charAt(len - 1) == '/' ? pathInfo.substring(1, len - 1) : pathInfo.substring(1);
	  }

	  public static void logRequest(HttpServletRequest req) {
	    LOGGER.info("******** HTTP REQUEST *********");
	    LOGGER.info("The Request QueryString " + req.getQueryString());
	    LOGGER.info("The Request RemoteAddr " + req.getRemoteAddr());
	    LOGGER.info("The RequestURL " + req.getRequestURL());
			LOGGER.info("The Request URI " + req.getRequestURI());

	  }

	  public static String decodeUTF8(String id) {
	    try {
	      return URLDecoder.decode(id, "UTF-8");
	    } catch (UnsupportedEncodingException e) {
	      throw Exceptions.handleThrowable(e);
	    }
	  }

	  public static String extractIdAndDecode(String pathInfo) {
	    return decodeUTF8(extractIdFromPathInfo(pathInfo));
	  }

	  public static void logUrl(URL url) {
	    LOGGER.info("Url Authority " + url.getAuthority());
	    LOGGER.info("Url Authority " + url.getDefaultPort());
	    LOGGER.info("Url Authority " + url.getFile());
	    LOGGER.info("Url Authority " + url.getHost());
	    LOGGER.info("Url Authority " + url.getPath());
	    LOGGER.info("Url Authority " + url.getPort());
	    LOGGER.info("Url Authority " + url.getProtocol());
	    LOGGER.info("Url Authority " + url.getQuery());
	    LOGGER.info("Url Authority " + url.getRef());
	    LOGGER.info("Url Authority " + url.getUserInfo());
	  }

	public static void logRequest(HttpServletRequest req, BaseHttpServlet.ReqMethod reqType) {
		RequestLogger.logRequest(req);
		LOGGER.info("The Request Method " + reqType.name());
	}
}