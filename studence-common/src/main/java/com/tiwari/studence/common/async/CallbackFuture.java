package com.tiwari.studence.common.async;

import java.util.List;
import java.util.Map;

import com.google.inject.Key;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.exception.Preconditions;

public class CallbackFuture<R, K extends Exception> extends DoneLatch
implements IFuture<R, K>, ICallback<R, K>, IDoneCallback {
private R m_result;
private K m_errors;
private LoggedRuntimeException m_exception;
private final Object m_doneLock = new Object();
private List<Pair<IDoneCallback, Map<Key<?>, Object>>> m_doneCallbacks = Lists.newArrayList();
private Object[] m_exceptionLogInfo = new Object[0];

public void setExceptionLogInfo(Object... logObjects) {
m_exceptionLogInfo = logObjects;
}

public void set(R response) {
m_result = response;
}

public void handleException(K errors) {
if (errors instanceof LoggedRuntimeException) {
handleUnexpectedException((LoggedRuntimeException) errors);
} else {
m_errors = errors;
}
}

public void handleUnexpectedException(LoggedRuntimeException exception) {
m_exception = exception;
}

public R get() throws K {
await();
if (m_exception != null) {
m_exception.addArgs(m_exceptionLogInfo);
LoggedRuntimeException stackTraceExp = new LoggedRuntimeException(m_exception,
      m_exceptionLogInfo);
m_exception.addArgs(stackTraceExp.getStackTraceString());
throw m_exception;
}
if (m_errors != null) {
Preconditions.check(m_errors instanceof ErrorException);
((ErrorException) m_errors).addArgs(m_exceptionLogInfo);
LoggedRuntimeException stackTraceExp = new LoggedRuntimeException(m_errors,
      m_exceptionLogInfo);
((ErrorException) m_errors).addArgs(stackTraceExp.getStackTraceString());
throw m_errors;
}
return m_result;
}

public final void addDoneCallback(IDoneCallback callback) {
if (callback == null) {
return;
}
boolean callImmediately = false;
synchronized (m_doneLock) {
if (m_doneCallbacks == null) {
callImmediately = true;
} else {
m_doneCallbacks.add(new Pair<IDoneCallback, Map<Key<?>, Object>>(callback,
        RequestScopeHelper.getScopedObjectMap()));
}
}
if (callImmediately) {
callback.done();
}
}

private final void invokeDoneCallbacks() {
List<Pair<IDoneCallback, Map<Key<?>, Object>>> callbacksToCall = null;
synchronized (m_doneLock) {
callbacksToCall = m_doneCallbacks;
// To make sure that any new done callbacks are immediately notified.
m_doneCallbacks = null;
}
callCallbacks(callbacksToCall);
}

private final void callCallbacks(List<Pair<IDoneCallback, Map<Key<?>, Object>>> callbacksToCall) {
if (callbacksToCall != null) {
Map<Key<?>, Object> incomingThreadScopeObject = RequestScopeHelper.getScopedObjectMap();
for (Pair<IDoneCallback, Map<Key<?>, Object>> doneCallback : callbacksToCall) {
RequestScopeHelper.changeScopeIfRequired(doneCallback.getSecond());
try {
  doneCallback.getFirst().done();
} catch (Throwable t) {
  Exceptions.handleThrowable(t);
} finally {
  Preconditions.check(doneCallback.getSecond() == RequestScopeHelper.getScopedObjectMap(),
          "RequestScope different", doneCallback.getSecond(),
          RequestScopeHelper.getScopedObjectMap());
  RequestScopeHelper.changeScopeIfRequired(incomingThreadScopeObject);
}
}
}
}

@Override
public void done() {
super.done();
invokeDoneCallbacks();
}

@Override
public boolean isDone() {
return m_doneCallbacks == null;
}

@Override
public K getCheckedException() {
return m_errors;
}

@Override
public LoggedRuntimeException getUnexpectedException() {
return m_exception;
}

}
