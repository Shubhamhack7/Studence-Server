package com.tiwari.studence.common.async;

import com.tiwari.studence.util.exception.LoggedRuntimeException;

public class SyncFuture<R, E extends Exception> extends CallbackFuture<R, E> {
	public SyncFuture() {
		done();
	}

	public SyncFuture(R response) {
		set(response);
		done();
	}

	public SyncFuture(E error) {
		handleException(error);
		done();
	}

	public SyncFuture(LoggedRuntimeException le) {
		handleUnexpectedException(le);
		done();
	}
}