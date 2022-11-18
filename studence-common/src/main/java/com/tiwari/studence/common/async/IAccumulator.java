package com.tiwari.studence.common.async;

import com.tiwari.studence.proto.time.AccumulatedTimeStatsPb;

public interface IAccumulator {
	public void accumulateValue(String statId, long value);

	AccumulatedTimeStatsPb getAccumulatedTimeStatsPb();
}