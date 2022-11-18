package com.tiwari.studence.common.async;

import java.util.List;

import com.tiwari.studence.util.exception.VoidException;

public interface IBatchAsyncCall<R, E extends Exception> {
	  public void startAsyncCall();

	  public IFuture<List<IFuture<R, E>>, VoidException> getFutureResults();

	  public IFuture<R, E> getFutureResult();
	}
