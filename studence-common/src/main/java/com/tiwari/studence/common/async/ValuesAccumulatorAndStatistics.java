package com.tiwari.studence.common.async;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

import com.google.inject.Singleton;
import com.tiwari.studence.proto.time.AccumulatedTimeStatsPb;
import com.tiwari.studence.proto.time.TimeStatsPb;
import com.tiwari.studence.util.collect.ExtendedMaps;

@Singleton
public class ValuesAccumulatorAndStatistics implements IAccumulator {
  private final ConcurrentMap<String, IStatistics> m_statIdsStatisticsMap;

  public ValuesAccumulatorAndStatistics() {
    m_statIdsStatisticsMap = ExtendedMaps.newConcurrentHashMap();
  }

  @Override
  public void accumulateValue(String statId, long value) {
    IStatistics newStatistics = getStatistics();
    m_statIdsStatisticsMap.putIfAbsent(statId, newStatistics);
    IStatistics statistics = m_statIdsStatisticsMap.get(statId);
    statistics.submitValue(value);
  }

  private IStatistics getStatistics() {
    return new CumulativeStatistics();
  }

  @Override
  public AccumulatedTimeStatsPb getAccumulatedTimeStatsPb() {
    AccumulatedTimeStatsPb.Builder builder = AccumulatedTimeStatsPb.newBuilder();
    for (Entry<String, IStatistics> statIdStatistics : m_statIdsStatisticsMap.entrySet()) {
      setTimeStats(statIdStatistics, builder);
    }
    return builder.build();
  }

  private void setTimeStats(Entry<String, IStatistics> statIdStatistics,
          AccumulatedTimeStatsPb.Builder builder) {
    TimeStatsPb.Builder timeStatsBuilder = TimeStatsPb
            .newBuilder(statIdStatistics.getValue().getTimeStats());
    // timeStatsBuilder.mergeFrom(statIdStatistics.getValue().getTimeStats());
    timeStatsBuilder.setId(statIdStatistics.getKey());
    builder.addTimeStats(timeStatsBuilder.build());
  }
}
