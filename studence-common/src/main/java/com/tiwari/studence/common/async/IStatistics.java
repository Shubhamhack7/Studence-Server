package com.tiwari.studence.common.async;

import com.tiwari.studence.proto.time.TimeStatsPb;

public interface IStatistics {
	public void submitValue(long value);

	public TimeStatsPb getTimeStats();
}
