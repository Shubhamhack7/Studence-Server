package com.tiwari.studence.common.async;

import com.tiwari.studence.util.exception.Preconditions;

public class Timer implements ITimer {
	private long m_startTime;
	private long m_endTime;
	private boolean m_timerStarted;
	private boolean m_timerStopped;

	@Override
	public void startTimer() {
		Preconditions.check(!m_timerStarted, "Timer is already started, can't start twice");
		m_timerStarted = true;
		m_startTime = System.currentTimeMillis();
	}

	@Override
	public void stopTimer() {
		Preconditions.check(!m_timerStopped, "Timer is already stopped, can't stop twice");
		m_timerStopped = true;
		m_endTime = System.currentTimeMillis();
	}

	@Override
	public long getDuration() {
		Preconditions.check(m_timerStarted, "The timer wasn't started");
		Preconditions.check(m_timerStopped, "The timer wasn't stopped");
		return m_endTime - m_startTime;
	}
}