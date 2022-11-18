package com.tiwari.studence.common.async;

import com.tiwari.studence.common.async.ABatchAsyncCall.TIME_STATS_ID;
import com.tiwari.studence.proto.requestcontext.RequestContextPb;
import com.tiwari.studence.proto.time.AccumulatedTimeStatsIdPb;
import com.tiwari.studence.proto.time.TimeProfileDimensionEnum;
import com.tiwari.studence.proto.time.TimeProfileDimensionId;

public class TimingControlFlowHook {
	private String m_callName;
	private IAccumulator m_timeStats;
	private ITimer m_waitTimer;
	private ITimer m_callTimer;
	private String m_stateNme;	
	private ITimer m_stateTimer;

	public void asyncCallCreate(Object call) {
		String callName = call.getClass().getSimpleName();
		String canonicalName = call.getClass().getCanonicalName()	;
		m_callName = callName;
		m_timeStats = TimeStatisticsFactory.getInstance(getAccumulatedTimeStatsIdPb(canonicalName));
		m_waitTimer = new Timer();
		m_waitTimer.startTimer();
		m_callTimer = new Timer();
		m_callTimer.startTimer();
	}

	public void callStart() {
		m_waitTimer.stopTimer();
		m_timeStats.accumulateValue(TIME_STATS_ID.WAIT + m_callName, m_waitTimer.getDuration());
	}

	public void callEnded() {
		m_callTimer.stopTimer();
		m_timeStats.accumulateValue(TIME_STATS_ID.TOTAL + m_callName, m_callTimer.getDuration());
	}

	public void stateStart(String name) {
		m_stateNme = name;
		m_stateTimer = new Timer();
		m_stateTimer.startTimer();
	}

	public void stateEnded() {
		m_stateTimer.stopTimer();
		m_timeStats.accumulateValue(m_stateNme, m_stateTimer.getDuration());
	}

	  private final AccumulatedTimeStatsIdPb getAccumulatedTimeStatsIdPb(String canonicalName) {
	    AccumulatedTimeStatsIdPb.Builder builder = AccumulatedTimeStatsIdPb.newBuilder();
	    TimeProfileDimensionId.Builder dimensionIdBuilder = builder.addDimensionIdBuilder();
	    RequestContextPb servletRequest = RequestScopeHelper.getRequestContext();
	    dimensionIdBuilder.setName(TimeProfileDimensionEnum.CONTEXT);
	    dimensionIdBuilder.setValue(servletRequest.toString());
	    dimensionIdBuilder = builder.addDimensionIdBuilder();
	    dimensionIdBuilder.setName(TimeProfileDimensionEnum.CLASS);
	    dimensionIdBuilder.setValue(canonicalName);
	    return builder.build();
	  }
}
