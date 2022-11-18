package com.tiwari.studence.common.async;

import com.google.inject.Singleton;
import com.tiwari.studence.proto.time.TimeStatsPb;

@Singleton
public class CumulativeStatistics implements IStatistics {
	private long m_totalValue;
	private int m_totalData;
	private long m_minValue = Long.MAX_VALUE;
	private long m_maxValue = Long.MIN_VALUE;
	protected final Object m_lockObject = new Object();

	@Override
	public void submitValue(long value) {
		synchronized (m_lockObject) {
			m_totalValue += value;
			m_totalData++;
			if (value < m_minValue) {
				m_minValue = value;
			}
			if (value > m_maxValue) {
				m_maxValue = value;
			}
		}
	}

	@Override
	public TimeStatsPb getTimeStats() {
		TimeStatsPb.Builder builder = TimeStatsPb.newBuilder();
		synchronized (m_lockObject) {
			double avg = m_totalValue / m_totalData;
			builder.setAvg(avg);
			builder.setMaxValue((int) m_maxValue);
			builder.setMinValue((int) m_minValue);
			builder.setTotalData(m_totalData);
			builder.setTotalValue((int) m_totalValue);
		}
		return builder.build();
	}
}
