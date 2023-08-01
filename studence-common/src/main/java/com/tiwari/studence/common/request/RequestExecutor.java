package com.tiwari.studence.common.request;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import com.google.common.base.Strings;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.InvokingFuturesGetDoneCallback;
import com.tiwari.studence.common.async.RequestScopeHelper;
import com.tiwari.studence.common.async.SyncFuture;
import com.tiwari.studence.common.injector.StaticInjectorProvider;
import com.tiwari.studence.proto.requestcontext.ReqPriorityUiEnum;
import com.tiwari.studence.proto.requestcontext.RequestContextPb;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.log.IServerExceptionLogger;

@Singleton
public class RequestExecutor {
  private final IServerExceptionLogger m_logger;

  public static RequestExecutor getInstance() {
    return StaticInjectorProvider.getInjector().getInstance(RequestExecutor.class);
  }

  @Inject
  public RequestExecutor(IServerExceptionLogger logger) {
    m_logger = logger;
  }

  public <T, E extends Exception> IFuture runRequestInContext(String reqClassName,
          Callable<IFuture> callable) {
    return runRequestInContext(reqClassName, null, ReqPriorityUiEnum.UNKNOWN_REQ_PRIORITY,
            callable);
  }

  public <T, E extends Exception> IFuture runRequestInContext(String reqClassName, String reqMethod,
          Callable<IFuture> callable) {
    return runRequestInContext(reqClassName, reqMethod, ReqPriorityUiEnum.UNKNOWN_REQ_PRIORITY,
            callable);
  }

  public <T, E extends Exception> IFuture runRequestInContext(String reqClassName,
          ReqPriorityUiEnum priority, Callable<IFuture> callable) {
    return runRequestInContext(reqClassName, null, priority, callable);
  }

  public IFuture runRequestInContext(String reqClassName, String reqMethod,
          ReqPriorityUiEnum priority, Callable<IFuture> callable) {
    Preconditions.check(!Strings.isNullOrEmpty(reqClassName), reqClassName);
    Map<Key<?>, Object> map = RequestScopeHelper.getScopedObjectMap();
    RequestContextPb.Builder builder = RequestContextPb.newBuilder();
    builder.setReqClass(reqClassName);
    if (!Strings.isNullOrEmpty(reqMethod)) {
      builder.setReqMethod(reqMethod);
    }
    RequestContextPb callerContext = RequestScopeHelper.getRequestContext();
    if (callerContext != null) {
      Preconditions.check(ReqPriorityUiEnum.UNKNOWN_REQ_PRIORITY == priority, priority);
      builder.setPriority(callerContext.getPriority());
    } else if (ReqPriorityUiEnum.UNKNOWN_REQ_PRIORITY != priority) {
      builder.setPriority(priority);
    }
    RequestScopeHelper.enterNewRequest(builder.build());
    try {
      IFuture entityFuture = callable.call();
      new InvokingFuturesGetDoneCallback(m_logger, reqClassName + reqMethod, entityFuture);
      return entityFuture;
    } catch (Throwable t) {
      IFuture entityFuture = new SyncFuture(Exceptions.handleThrowable(t));
      new InvokingFuturesGetDoneCallback(m_logger, reqClassName + reqMethod, entityFuture);
      return entityFuture;
    } finally {
      RequestScopeHelper.changeScope(map);
    }
  }
}