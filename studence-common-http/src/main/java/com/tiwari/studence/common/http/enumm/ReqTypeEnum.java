package com.tiwari.studence.common.http.enumm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;

import com.google.common.base.Joiner;
import com.google.common.io.CharStreams;
import com.tiwari.studence.common.http.util.ServletUtil;
import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.proto.requestcontext.ReqTypeUiEnum;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.Preconditions;
import jakarta.servlet.http.HttpServletRequest;

interface IReqTypeHelper {
  public boolean isReqOfType(HttpServletRequest req);

  public String getReqData(HttpServletRequest req);

  public String getReqId(HttpServletRequest req);
}

// TODO : clean this.
public enum ReqTypeEnum {
  GET_ID(ReqTypeUiEnum.GET_ID, new GetIdHelper()),
  GET_BY_EXTERNAL_ID(ReqTypeUiEnum.GET_BY_EXTERNAL_ID, new GetByExternalIdHelper()),
  GET_LIST(ReqTypeUiEnum.GET_LIST, new GetListHelper()),
  CREATE(ReqTypeUiEnum.CREATE, new CreateHelper()),
  DELETE(ReqTypeUiEnum.DELETE, new DeleteHelper()),
  UPDATE(ReqTypeUiEnum.UPDATE, new UpdateHelper()),
  GET_OR_CREATE_BY_EXTERNALID(ReqTypeUiEnum.GET_OR_CREATE_BY_EXTERNALID,
          new GetOrCreateByExternalIdHelper(ReqTypeEnum.EXTERNALID_PATH_FOR_GETORCREATE)),
  //Use this for external request
  GET_OR_CREATE_BY_EXTERNALIDPB(ReqTypeUiEnum.GET_OR_CREATE_BY_EXTERNALIDPB,
          new GetOrCreateByExternalIdPbHelper(ReqTypeEnum.EXTERNALIDPB_PATH_FOR_GETORCREATE)),
  GET_BY_EXTERNALIDPB(ReqTypeUiEnum.GET_BY_EXTERNALIDPB,
          new GetByExternalIdPbHelper(ReqTypeEnum.EXTERNALIDPB_PATH_FOR_GET)),
  GET_OR_CREATE_LIST_BY_EXTERNALIDPB_LIST(ReqTypeUiEnum.GET_OR_CREATE_LIST_BY_EXTERNALIDPB_LIST,
          new GetOrCreateByExternalIdPbHelper(ReqTypeEnum.EXTERNALIDPB_PATH_FOR_GETORCREATE_LIST)),

  SAFE_CREATE_OR_GET_BY_EXTERNAL_ID(ReqTypeUiEnum.SAFE_CREATE_OR_GET_BY_EXTERNAL_ID,
          new SafeCreateOrGetByExternalIdHelper()),
  IMPORT(ReqTypeUiEnum.IMPORT, new ImportHelper(ReqTypeEnum.EXTERNAL_ID_PATH_FOR_IMPORT));

  static final String EXTERNALID_PATH_FOR_GETORCREATE = "/gc/";
  static final String EXTERNALIDPB_PATH_FOR_GETORCREATE = "/gcpb";
  static final String EXTERNALIDPB_PATH_FOR_GET = "/gpb/";
  static final String EXTERNALIDPB_PATH_FOR_GETORCREATE_LIST = "/gclpb";
  static final String EXTERNAL_ID_PATH_FOR_GET = "/eg/";
  static final String EXTERNAL_ID_PATH_FOR_SAFE_CREATE_OR_GET = "/scgpb";
  static final String EXTERNAL_ID_PATH_FOR_IMPORT = "/im";

  private final IReqTypeHelper m_helper;
  private final ReqTypeUiEnum m_req;

  private ReqTypeEnum(ReqTypeUiEnum req, IReqTypeHelper helper) {
    Preconditions.check(this.name() == req.name(), this, req);
    m_req = req;
    m_helper = helper;
  }

  public ReqTypeUiEnum getReqTypeUiEnum() {
    return m_req;
  }

  public static ReqTypeEnum getReqTypeEnum(ReqTypeUiEnum reqTypeUiEnum) {
    return ReqTypeEnum.valueOf(reqTypeUiEnum.name());
  }

  public boolean isReqOfType(HttpServletRequest req) {
    return m_helper.isReqOfType(req);
  }

  public String getReqString(HttpServletRequest req) {
    return m_helper.getReqData(req);
  }

  public String getReqId(HttpServletRequest req) {
    return m_helper.getReqId(req);
  }

  public static ReqTypeEnum getReqTypeEnum(HttpServletRequest req) {
    List<ReqTypeEnum> list = Arrays.asList(ReqTypeEnum.values());
    for (ReqTypeEnum reqTypeEnum : list) {
      if (reqTypeEnum.isReqOfType(req)) {
        return reqTypeEnum;
      }
    }
    return null;
  }

  private static String extractId(String pathInfo, String idQualifier) {
    String s = pathInfo.substring(idQualifier.length() - 1);
    return ServletUtil.extractIdAndDecode(s);
  }

  private static class GetIdHelper implements IReqTypeHelper {

    @Override
    public String getReqData(HttpServletRequest req) {
      Preconditions.check(false, "ReqData should not be called on GetIdHelper");
      return null;
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String pathInfo = req.getServletPath();
      String methodName = req.getMethod();
      return pathInfo != null && pathInfo.length() > 0 && pathInfo.charAt(
              0) == '/' && !GET_LIST.isReqOfType(req) && !GET_OR_CREATE_BY_EXTERNALIDPB.isReqOfType(
              req)/*&& !GET_BY_EXTERNAL_ID.isReqOfType(req)
	              && !GET_OR_CREATE_BY_EXTERNALID.isReqOfType(req)*/ && HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.GET;
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      String pathInfo = req.getServletPath();
      return ServletUtil.extractIdFromPathInfo(pathInfo);
    }
  }

  private static class GetByExternalIdHelper implements IReqTypeHelper {

    @Override
    public String getReqData(HttpServletRequest req) {
      Preconditions.check(false, "ReqData should not be called on GetByExternalIdHelper");
      return null;
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String methodName = req.getMethod();
      String pathInfo = req.getPathInfo();
      int length = EXTERNAL_ID_PATH_FOR_GET.length();
      return pathInfo != null && pathInfo.length() > length && pathInfo.substring(0, length)
              .equals(EXTERNAL_ID_PATH_FOR_GET) && HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.GET;
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      String pathInfo = req.getPathInfo();
      return extractId(pathInfo, EXTERNAL_ID_PATH_FOR_GET);
    }
  }

  private static class GetListHelper implements IReqTypeHelper {

    @Override
    public String getReqData(HttpServletRequest req) {
      String query = req.getRequestURI().split("=")[1];
      if (query == null || query.equals("")) {
        query = "{}";
      }
      return query;
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String pathInfo = req.getServletPath();
      String methodName = req.getMethod();
      return (pathInfo == null || pathInfo.equals("/") || pathInfo.contains(
              "/cache") || pathInfo.contains("/query")) && !GET_OR_CREATE_BY_EXTERNALID.isReqOfType(
              req) && HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.GET;
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      Preconditions.check(false, "ReqId should not be called on GetListHelper");
      return null;
    }
  }

  private static class CreateHelper implements IReqTypeHelper {

    @Override
    public String getReqData(HttpServletRequest req) {
      try {
        return Joiner.on(", ").join(CharStreams.readLines(getRequestReader(req)));
      } catch (IOException ioe) {
        throw Exceptions.handleThrowable(ioe);
      }
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String methodName = req.getMethod();
      return !GET_OR_CREATE_LIST_BY_EXTERNALIDPB_LIST.isReqOfType(
              req) && !SAFE_CREATE_OR_GET_BY_EXTERNAL_ID.isReqOfType(
              req) && !GET_OR_CREATE_BY_EXTERNALIDPB.isReqOfType(req) && !IMPORT.isReqOfType(
              req) && HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.POST;
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      Preconditions.check(false, "ReqId should not be called on CreateHelper");
      return null;
    }
  }

  private static class UpdateHelper implements IReqTypeHelper {

    @Override
    public String getReqData(HttpServletRequest req) {
      try {
        String data = Joiner.on(", ").join(CharStreams.readLines(getRequestReader(req)));
        Preconditions.check(Strings.notEmpty(data), ErrorTypePbEnum.VALIDATION_FAILED);
        return data;
      } catch (IOException ioe) {
        throw Exceptions.handleThrowable(ioe);
      }
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String methodName = req.getMethod();
      return HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.PUT;
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      String pathInfo = req.getPathInfo();
      return ServletUtil.extractIdFromPathInfo(pathInfo);
    }
  }

  private static class DeleteHelper implements IReqTypeHelper {

    @Override
    public String getReqData(HttpServletRequest req) {
      Preconditions.check(false, "ReqData should not be called on DeleteHelper");
      return null;
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String methodName = req.getMethod();
      return HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.DELETE;
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      String pathInfo = req.getPathInfo();
      return ServletUtil.extractIdFromPathInfo(pathInfo);
    }
  }

  private static class GetOrCreateByExternalIdHelper implements IReqTypeHelper {

    private String m_path;

    public GetOrCreateByExternalIdHelper(String path) {
      m_path = path;
    }

    @Override
    public String getReqData(HttpServletRequest req) {
      Preconditions.check(false, "ReqData should not be called on GetOrCreateByExternalIdHelper");
      return null;
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String pathInfo = req.getPathInfo();
      String methodName = req.getMethod();
      int length = m_path.length();
      return pathInfo != null && pathInfo.length() > length && pathInfo.substring(0, length)
              .equals(m_path) && HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.GET;
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      String pathInfo = req.getPathInfo();
      return extractId(pathInfo, m_path);
    }
  }

  private static class SafeCreateOrGetByExternalIdHelper implements IReqTypeHelper {

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String methodName = req.getMethod();
      String pathInfo = req.getPathInfo();
      int length = EXTERNAL_ID_PATH_FOR_SAFE_CREATE_OR_GET.length();
      return pathInfo != null && pathInfo.length() == length && pathInfo.substring(0, length)
              .equals(EXTERNAL_ID_PATH_FOR_SAFE_CREATE_OR_GET) && HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.POST;
    }

    @Override
    public String getReqData(HttpServletRequest req) {
      try {
        String data = Joiner.on(", ").join(CharStreams.readLines(getRequestReader(req)));
        Preconditions.check(Strings.notEmpty(data), ErrorTypePbEnum.VALIDATION_FAILED);
        return data;
      } catch (IOException ioe) {
        throw Exceptions.handleThrowable(ioe);
      }
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      Preconditions.check(false, "ReqID should not be called on SafeCreateOrGetByExternalIdHelper");
      return null;
    }

  }

  private static class GetOrCreateByExternalIdPbHelper implements IReqTypeHelper {

    private String m_path;

    public GetOrCreateByExternalIdPbHelper(String path) {
      m_path = path;
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String pathInfo = req.getServletPath();
      String methodName = req.getMethod();
      int length = m_path.length();
      return pathInfo != null && checkForGet(pathInfo, methodName,
              length) && pathInfo.length() > length && (HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.GET || HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.POST);
    }

    private boolean checkForGet(String pathInfo, String methodName, int length) {
      if (HttpRequestMethodEnum.getHttpRequestMethodEnum(methodName) == HttpRequestMethodEnum.GET) {
        String frontPathInfo = pathInfo.split("=")[0];
        return pathInfo.contains("=") && pathInfo.substring(
                (frontPathInfo.length() - length), frontPathInfo.length()).equals(m_path);
      } else if (HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.POST) {
        return pathInfo.substring((pathInfo.length() - length), pathInfo.length()).equals(m_path);
      } else {
        return false;
      }
    }

    @Override
    public String getReqData(HttpServletRequest req) {
      if (HttpRequestMethodEnum.getHttpRequestMethodEnum(
              req.getMethod()) == HttpRequestMethodEnum.GET) {
        String query = req.getRequestURI().split("=")[1];
        if (query == null || query.equals("")) {
          query = "{}";
        }
        return query;
      } else if (HttpRequestMethodEnum.getHttpRequestMethodEnum(
              req.getMethod()) == HttpRequestMethodEnum.POST) {
        try {
          return Joiner.on(", ").join(CharStreams.readLines(getRequestReader(req)));
        } catch (IOException ioe) {
          throw Exceptions.handleThrowable(ioe);
        }
      }
      return "";
      // Preconditions.check(false, "ReqData should not be called on GetOrCreateByExternalIdHelper")
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      String pathInfo = req.getPathInfo();
      return extractId(pathInfo, m_path);
    }

  }

  private static class GetByExternalIdPbHelper implements IReqTypeHelper {

    private String m_path;

    public GetByExternalIdPbHelper(String path) {
      m_path = path;
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String pathInfo = req.getPathInfo();
      String methodName = req.getMethod();
      int length = m_path.length();
      return pathInfo != null && pathInfo.length() > length && pathInfo.substring(0, length)
              .equals(m_path) && HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.GET;
    }

    @Override
    public String getReqData(HttpServletRequest req) {
      Preconditions.check(false, "ReqData should not be called on GetOrCreateByExternalIdHelper");
      return null;
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      String pathInfo = req.getPathInfo();
      return extractId(pathInfo, m_path);
    }

  }

  private static class ImportHelper implements IReqTypeHelper {

    private String m_path;

    public ImportHelper(String path) {
      m_path = path;
    }

    @Override
    public boolean isReqOfType(HttpServletRequest req) {
      String pathInfo = req.getPathInfo();
      String methodName = req.getMethod();
      int length = m_path.length();
      return pathInfo != null && pathInfo.length() == length && pathInfo.substring(0, length)
              .equals(m_path) && HttpRequestMethodEnum.getHttpRequestMethodEnum(
              methodName) == HttpRequestMethodEnum.POST;
    }

    @Override
    public String getReqData(HttpServletRequest req) {
      try {
        return Joiner.on(", ").join(CharStreams.readLines(getRequestReader(req)));
      } catch (IOException ioe) {
        throw Exceptions.handleThrowable(ioe);
      }
    }

    @Override
    public String getReqId(HttpServletRequest req) {
      Preconditions.check(false, "ReqId should not be called on ImportHelper");
      return null;
    }

  }

  private static BufferedReader getRequestReader(HttpServletRequest request) throws IOException {
    String ce = request.getHeader("Content-Encoding");
    if (ce != null && ce.indexOf("gzip") != -1) {
      System.out.println(request.getInputStream());
      GZIPInputStream gzipInputStream = new GZIPInputStream(request.getInputStream());
      return new BufferedReader(new InputStreamReader(gzipInputStream));
    }
    return request.getReader();
  }

}