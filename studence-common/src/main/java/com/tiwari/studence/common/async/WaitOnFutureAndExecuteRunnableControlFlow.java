package com.tiwari.studence.common.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import com.tiwari.studence.util.callable.ALoggableCallable;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Exceptions;

public class WaitOnFutureAndExecuteRunnableControlFlow<R, E extends Exception>
		extends AControlFlow<WaitOnFutureAndExecuteRunnableControlFlow.State, R, E> {
	enum State {
		WAIT_FOR_FUTURE, DONE;
	}

	private final List<IFuture<?, ?>> m_futures;
	private final Callable<R> m_callable;

	private WaitOnFutureAndExecuteRunnableControlFlow(Callable<R> call, List<IFuture<?, ?>> futures) {
		super(State.WAIT_FOR_FUTURE, State.DONE);
		m_futures = futures;
		m_callable = call;
		addStateHandler(State.WAIT_FOR_FUTURE, new WaitForFutureHandler());
	}

	public static <R, E extends Exception> IFuture<R, E> waitAndExecuteCallable(Callable<R> call,
			List<IFuture<?, ?>> futures) {
		WaitOnFutureAndExecuteRunnableControlFlow<R, E> cf = new WaitOnFutureAndExecuteRunnableControlFlow<R, E>(call,
				futures);
		if (call instanceof ALoggableCallable) {
			cf.addLogObjects(((ALoggableCallable) call).getLogInfo());
		}
		cf.startAsyncCall();
		return cf.getFutureResult();
	}

	public static <R, E extends Exception> IFuture<R, E> waitAndExecuteCallable(Callable<R> call,
			IFuture<?, ?>... future) {
		return waitAndExecuteCallable(call, Arrays.asList(future));
	}

	private class WaitForFutureHandler implements StateHandler<State> {
		@Override
		public void registerCalls() {
			registerFutures(m_futures);
		}

		@Override
		public State handleState() {
			try {
				if (m_callable != null) {
					getAsyncCallback().set(0, m_callable.call());
				}
			} catch (Throwable ex) {
				if (ex instanceof ErrorException) {
					getAsyncCallback().handleException(0, (E) ex);
				} else {
					getAsyncCallback().handleUnexpectedException(Exceptions.handleThrowable(ex));
				}
			}
			return State.DONE;
		}
	}
}
