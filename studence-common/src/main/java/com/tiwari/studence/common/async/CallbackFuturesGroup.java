package com.tiwari.studence.common.async;

import java.util.Arrays;
import java.util.List;

import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.exception.VoidException;

public class CallbackFuturesGroup<R, K extends Exception> extends CallbackFuture<List<IFuture<R, K>>, VoidException> {
	private final List<ICallback<R, K>> m_callbacks;
	private final IFuture<R, K> m_firstFuture;

	public CallbackFuturesGroup(int noOfRequests) {
		Preconditions.check(noOfRequests > 0, "No Of requests should be atleast one");
		CallbackFuture<R, K>[] callbackFutures = new CallbackFuture[noOfRequests];
		for (int i = 0; i < noOfRequests; ++i) {
			callbackFutures[i] = new CallbackFuture();
		}
		m_firstFuture = callbackFutures[0];
		m_callbacks = Arrays.asList((ICallback<R, K>[]) callbackFutures);
		List<IFuture<R, K>> futures = Arrays.asList((IFuture<R, K>[]) callbackFutures);
		set(futures);
	}

	public void handleUnexpectedException(LoggedRuntimeException exception) {
		for (ICallback<R, K> callback : m_callbacks) {
			callback.handleUnexpectedException(exception);
		}
		super.handleUnexpectedException(exception);
	}

	public void setExceptionLogInfo(Object... logObjects) {
		for (ICallback<R, K> callback : m_callbacks) {
			((CallbackFuture<R, K>) callback).setExceptionLogInfo(logObjects);
		}
		super.setExceptionLogInfo(logObjects);
	}

	public void done() {
		super.done();
		for (IDoneCallback callback : m_callbacks) {
			callback.done();
		}
	}

	public void set(int i, R data) {
		Preconditions.check(i < m_callbacks.size(), "Index is more than number of requests");
		m_callbacks.get(i).set(data);
	}

	public void handleException(int i, K exception) {
		Preconditions.check(i < m_callbacks.size(), "Index is more than number of requests");
		m_callbacks.get(i).handleException(exception);
	}

	IFuture<R, K> getEnclosedFuture() {
		Preconditions.check(m_callbacks.size() == 1, "This method can be called only for one request");
		return m_firstFuture;
	}
}
