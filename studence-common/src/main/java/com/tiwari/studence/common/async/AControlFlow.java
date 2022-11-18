package com.tiwari.studence.common.async;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Maps;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.exception.Preconditions;

public abstract class AControlFlow<E extends Enum<E>, R, K extends Exception> extends ABatchAsyncCall<R, K> {
	protected static interface StateHandler<E extends Enum<E>> {
		public void registerCalls();

		public E handleState();
	}

	private Map<E, StateHandler<E>> stateHandlerMap = Maps.newHashMap();
	private DoneCallbackImpl doneCallback = new DoneCallbackImpl();

	private Object m_countLock = new Object();
	private int m_callCount;
	private E m_currentState;
	private boolean m_callRegisterFutures = true;
	private final E m_endState;
	private final List<Object> m_logObjects = Lists.newArrayList();

	protected AControlFlow(E startState, E endState) {
		this(startState, endState, 1);
	}

	protected AControlFlow(E startState, E endState, int reqCount) {
		super(reqCount);
		m_currentState = startState;
		this.m_endState = endState;
		getAsyncCallback().setExceptionLogInfo(m_logObjects);
	}

	public void addLogObjects(Object... logs) {
		m_logObjects.addAll(Arrays.asList(logs));
	}

	@Override
	protected final void startAsyncCallInternal() {
		handleStateChange();
	}

	protected final void addStateHandler(E state, StateHandler<E> handler) {
		Preconditions.check(state != m_endState, "End state is just a dummy state. It shouldn't have a handler.");
		stateHandlerMap.put(state, handler);
	}

	protected final void registerFutures(IFuture<?, ?>... futures) {
// We should first increment and then only set doneCallback since
// doneCallback might be immediately called and it will try to decrement.
		incrementCount(futures.length);
		for (IFuture<?, ?> future : futures) {
			future.addDoneCallback(doneCallback);
		}
	}

	protected final void registerFutures(List<IFuture<?, ?>> futures) {
		incrementCount(futures.size());
		for (IFuture<?, ?> future : futures) {
			future.addDoneCallback(doneCallback);
		}
	}

	private void incrementCount(int count) {
		Preconditions.check(m_callRegisterFutures, "Calls should be registered in registerFutures only");
		synchronized (m_countLock) {
			m_callCount += count;
		}
	}

	private void decrementCount() {
		synchronized (m_countLock) {
			m_callCount--;
			if (m_callCount != 0) {
				return;
			}
		}
		handleStateChange();
	}

	private void handleStateChange() {
// terminate control flow if it is end state.
		if (m_endState == m_currentState) {
			getAsyncCallback().done();
			return;
		}
// The call count is initialized as 1 since the current handleStateChange
// call also has to finish before the next state change can be executed.
		try {
			m_callCount = 1;
			StateHandler<E> handler = stateHandlerMap.get(m_currentState);
			if (m_callRegisterFutures) {
				if (m_cfHook != null) {
					m_cfHook.stateStart(m_currentState.toString());
				}
				handler.registerCalls();
				m_callRegisterFutures = false;
			} else {
				m_currentState = handler.handleState();
				if (m_cfHook != null) {
					m_cfHook.stateEnded();
				}
				m_callRegisterFutures = true;
			}
// Decrement count won't be called in case of any runtime exception. This
// prevents invoking
// of handleStateChange when other registerFutures finish.
			decrementCount();
		} catch (Throwable exception) {
			LoggedRuntimeException exp = Exceptions.handleThrowable(exception);
			getAsyncCallback().handleUnexpectedException(exp);
			getAsyncCallback().done();
		}
	}

	private class DoneCallbackImpl implements IDoneCallback {
		@Override
		public void done() {
			decrementCount();
		}
	}
}
