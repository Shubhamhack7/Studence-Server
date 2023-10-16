package com.tiwari.studence.common.http.servlet;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import com.google.protobuf.GeneratedMessageV3;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.error.ErrorResponsePbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToPbConverter;
import com.tiwari.studence.common.http.converter.JsonStringToReqPbConverter;
import com.tiwari.studence.common.http.enumm.ReqTypeEnum;
import com.tiwari.studence.common.http.util.ServletUtil;
import com.tiwari.studence.common.provider.IPbBuilderProvider;
import com.tiwari.studence.common.provider.IReqRespPbBuilderProvider;
import com.tiwari.studence.common.request.RequestExecutor;
import com.tiwari.studence.common.services.interfaces.*;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.log.IServerExceptionLogger;
import com.tiwari.studence.util.serverConfig.ServerConfigUtility;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

public abstract class AHttpEntityServlet<Service, UiPb extends GeneratedMessageV3, Lreq extends GeneratedMessageV3, Lresp extends GeneratedMessageV3, UiPbBuProvider extends IPbBuilderProvider<?, ?>, ReqPbBuProvider extends IReqRespPbBuilderProvider<?, ?, ?, ?>>
        extends BaseHttpServlet {
  private static final long serialVersionUID = 46097369299251403L;

  private final JsonStringToPbConverter<UiPb, UiPbBuProvider> m_reqParser;
  private final JsonStringToReqPbConverter<Lreq, ReqPbBuProvider> m_searchReqParser;
  private final Service m_service;

  @Inject
  public AHttpEntityServlet(JsonStringToPbConverter<UiPb, UiPbBuProvider> reqParser,
          JsonStringToReqPbConverter<Lreq, ReqPbBuProvider> searchReqParser, Service service,
          ErrorResponsePbConverter errorResponsePbConverter, IServerExceptionLogger exLogger,
          ResponseInterceptor responseInterceptor, ServerConfigUtility serverConfigUtility) {
    super(errorResponsePbConverter, exLogger, responseInterceptor, serverConfigUtility);
    m_reqParser = reqParser;
    m_searchReqParser = searchReqParser;
    m_service = service;
  }

  private IFuture<?, Exception> postInternal(HttpServletRequest req) {
    ReqTypeEnum reqTypeEnum = null;
    reqTypeEnum = ReqTypeEnum.getReqTypeEnum(req);
    Preconditions.validateWithUiErrorString(reqTypeEnum != null, "Unknown Operation on Resourse",
            "", req.getPathInfo(), req.getMethod());
    ;
    switch (reqTypeEnum) {
    case CREATE:
      String reqString = reqTypeEnum.getReqString(req);
      UiPb reqUiPb = m_reqParser.convert(reqString);
      return (IFuture) createResource(reqUiPb);
    default:
      Preconditions.validateWithUiErrorString(false, "Unknown Operation on Resourse", "",
              req.getPathInfo(), req.getMethod());
      return null;
    }
  }

  private IFuture<?, Exception> putInternal(HttpServletRequest req) {
    ReqTypeEnum reqTypeEnum = null;
    reqTypeEnum = ReqTypeEnum.getReqTypeEnum(req);
    Preconditions.validateWithUiErrorString(reqTypeEnum != null, "Unknown Operation on Resourse",
            "", req.getPathInfo(), req.getMethod());
    ;
    switch (reqTypeEnum) {
    case UPDATE:
      String reqId = reqTypeEnum.getReqId(req);
      String reqString = reqTypeEnum.getReqString(req);
      UiPb reqUiPb = m_reqParser.convert(reqString);
      return (IFuture) updateResource(reqId, reqUiPb);
    default:
      Preconditions.validateWithUiErrorString(false, "Unknown Operation on Resourse", "",
              req.getPathInfo(), req.getMethod());
      return null;
    }
  }

  private IFuture<?, Exception> deleteInternal(HttpServletRequest req) {
    ReqTypeEnum reqTypeEnum = null;
    reqTypeEnum = ReqTypeEnum.getReqTypeEnum(req);
    Preconditions.validateWithUiErrorString(reqTypeEnum != null, "Unknown Operation on Resourse",
            "", req.getPathInfo(), req.getMethod());
    ;
    switch (reqTypeEnum) {
    case DELETE:
      String reqId = reqTypeEnum.getReqId(req);
      return (IFuture) deleteResource(reqId);
    default:
      Preconditions.validateWithUiErrorString(false, "Unknown Operation on Resourse", "",
              req.getPathInfo(), req.getMethod());
      return null;
    }
  }

  private IFuture<?, Exception> getInternal(HttpServletRequest req) {
    System.out.print("my servlet");
    ReqTypeEnum reqTypeEnum = null;
    reqTypeEnum = ReqTypeEnum.getReqTypeEnum(req);
    Preconditions.validateWithUiErrorString(reqTypeEnum != null, "Unknown Operation on Resourse",
            "", req.getPathInfo(), req.getMethod());
    ;
    switch (reqTypeEnum) {
    case GET_ID: {
      String reqId = reqTypeEnum.getReqId(req);
      return (IFuture) getResource(reqId);
    }
    case GET_LIST: {
      String dataReq = reqTypeEnum.getReqString(req);
      return (IFuture) getResourceList(m_searchReqParser.convert(dataReq));
    }
    default:
      Preconditions.validateWithUiErrorString(false, "Unknown Operation on Resourse", "",
              req.getPathInfo(), req.getMethod());
      return null;
    }
  }

  private IFuture<UiPb, ErrorException> getResource(final String id) {
    if (m_service instanceof IGetEntity) {
      return (IFuture<UiPb, ErrorException>) RequestExecutor.getInstance()
              .runRequestInContext(m_service.getClass().getSimpleName(),
                      IGetEntity.class.getSimpleName(), new Callable<IFuture>() {
                        @Override
                        public IFuture<UiPb, ErrorException> call() throws Exception {
                          return ((IGetEntity) m_service).getEntity(id);
                        }
                      });
    }
    Preconditions.validate(false, "Get is not supported for this resource");
    return null;
  }

  private IFuture<Lresp, ErrorException> getResourceList(final Lreq listRequest) {
    if (m_service instanceof IEntityService) {
      return (IFuture<Lresp, ErrorException>) RequestExecutor.getInstance()
              .runRequestInContext(m_service.getClass().getSimpleName(),
                      IEntityService.class.getSimpleName(), new Callable<IFuture>() {
                        @Override
                        public IFuture<Lresp, ErrorException> call() throws Exception {
                          return ((IEntityService) m_service).search(listRequest);
                        }
                      });
    }
    Preconditions.validate(false, "Search is not supported for this resource");
    return null;
  }

  private IFuture<UiPb, ErrorException> createResource(final UiPb request) {
    if (m_service instanceof ICreateEntity) {
      return (IFuture<UiPb, ErrorException>) RequestExecutor.getInstance()
              .runRequestInContext(m_service.getClass().getSimpleName(),
                      ICreateEntity.class.getSimpleName(), new Callable<IFuture>() {
                        @Override
                        public IFuture<UiPb, ErrorException> call() throws Exception {
                          return ((ICreateEntity) m_service).createEntity(request);
                        }
                      });
    }
    Preconditions.validate(false, "Create is not supported for this resource");
    return null;
  }

  //	private IFuture<UiPb, VoidException> safeCreateResource(final UiPb request) {
  //		if (m_service instanceof ISafeCreateByExternalId) {
  //			return (IFuture<UiPb, VoidException>) RequestExecutor.getInstance().runRequestInContext(
  //					m_service.getClass().getSimpleName(), ISafeCreateByExternalId.class.getSimpleName(),
  //					new Callable<IFuture>() {
  //						@Override
  //						public IFuture<UiPb, VoidException> call() throws Exception {
  //							return ((ISafeCreateByExternalId) m_service).safeCreateByExternalId(request);
  //						}
  //					});
  //		}
  //		Preconditions.validate(false, "Safe Create is not supported for this resource");
  //		return null;
  //	}

  //	private IFuture<UiPb, VoidException> importResource(final UiPb request) {
  //		if (m_service instanceof IEntityImport) {
  //			return (IFuture<UiPb, VoidException>) RequestExecutor.getInstance().runRequestInContext(
  //					m_service.getClass().getSimpleName(), IEntityImport.class.getSimpleName(), new Callable<IFuture>() {
  //						@Override
  //						public IFuture<UiPb, VoidException> call() throws Exception {
  //							return ((IEntityImport) m_service).importRef(request);
  //						}
  //					});
  //		}
  //		Preconditions.validate(false, "Import is not supported for this resource");
  //		return null;
  //	}

  private IFuture<UiPb, ErrorException> deleteResource(final String id) {
    if (m_service instanceof IDeleteEntity) {
      return (IFuture<UiPb, ErrorException>) RequestExecutor.getInstance()
              .runRequestInContext(m_service.getClass().getSimpleName(),
                      IDeleteEntity.class.getSimpleName(), new Callable<IFuture>() {
                        @Override
                        public IFuture<UiPb, ErrorException> call() throws Exception {
                          return ((IDeleteEntity) m_service).deleteEntity(id);
                        }
                      });
    }
    Preconditions.validate(false, "Delete is not supported for this resource");
    return null;
  }

  private IFuture<UiPb, ErrorException> updateResource(final String id, final UiPb request) {
    if (m_service instanceof IUpdateEntity) {
      return (IFuture<UiPb, ErrorException>) RequestExecutor.getInstance()
              .runRequestInContext(m_service.getClass().getSimpleName(),
                      IUpdateEntity.class.getSimpleName(), new Callable<IFuture>() {
                        @Override
                        public IFuture<UiPb, ErrorException> call() throws Exception {
                          return ((IUpdateEntity) m_service).updateEntity(id, request);
                        }
                      });
    }
    Preconditions.validate(false, "Update is not supported for this resource");
    return null;
  }

  //	private IFuture<UiPb, ErrorException> getOrCreateByExternalIdPb(final ExIdPbReq externalIdPb) {
  //		if (m_service instanceof IGetOrCreateByExternalIdPb) {
  //			return (IFuture<UiPb, ErrorException>) RequestExecutor.getInstance().runRequestInContext(
  //					m_service.getClass().getSimpleName(), IGetOrCreateByExternalIdPb.class.getSimpleName(),
  //					new Callable<IFuture>() {
  //						@Override
  //						public IFuture<UiPb, ErrorException> call() throws Exception {
  //							return ((IGetOrCreateByExternalIdPb) m_service).getOrCreateByExternalIdPb(externalIdPb);
  //						}
  //					});
  //		}
  //		Preconditions.validate(false, "Get or Create By ExternalId is not supported for this resource");
  //		return null;
  //	}

  //	private IFuture<UiPb, ErrorException> getByExternalIdPb(final ExIdPbReq externalIdPb) {
  //		if (m_service instanceof IGetEntityByExternalIdPb) {
  //			return (IFuture<UiPb, ErrorException>) RequestExecutor.getInstance().runRequestInContext(
  //					m_service.getClass().getSimpleName(), IGetEntityByExternalIdPb.class.getSimpleName(),
  //					new Callable<IFuture>() {
  //						@Override
  //						public IFuture<UiPb, ErrorException> call() throws Exception {
  //							return ((IGetEntityByExternalIdPb) m_service).getEntityByExternalId(externalIdPb);
  //						}
  //					});
  //		}
  //		Preconditions.validate(false, "GetByExternalId is not supported for this resource");
  //		return null;
  //	}

  @Override
  protected IFuture<?, Exception> handleAsyncCall(HttpServletRequest req, ReqMethod reqType) {
    ServletUtil.logRequest(req, reqType);
    switch (reqType) {
    case POST:
      return postInternal(req);
    case PUT:
      return putInternal(req);
    case DELETE:
      return deleteInternal(req);
    case GET:
      return getInternal(req);
    default:
      Preconditions.check(false);
      return null;
    }
  }

}