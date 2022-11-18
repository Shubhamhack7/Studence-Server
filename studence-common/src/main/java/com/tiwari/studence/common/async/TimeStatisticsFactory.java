package com.tiwari.studence.common.async;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import com.tiwari.studence.proto.time.AccumulatedTimeStatsIdPb;
import com.tiwari.studence.proto.time.AccumulatedTimeStatsPb;
import com.tiwari.studence.proto.time.TimeProfileDimensionEnum;
import com.tiwari.studence.proto.time.TimeProfileDimensionId;
import com.tiwari.studence.util.collect.ExtendedMaps;
import com.tiwari.studence.util.collect.ExtendedSets;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.collect.Sets;

public class TimeStatisticsFactory {
	private static AtomicLong m_id = new AtomicLong(0);
	private static final ConcurrentMap<AccumulatedTimeStatsIdPb, IAccumulator> s_instanceMap = ExtendedMaps
			.newConcurrentHashMap();
	private static final ConcurrentMap<TimeProfileDimensionEnum, ConcurrentMap<String, Set<Pair<Long, AccumulatedTimeStatsIdPb>>>> s_indexMap = ExtendedMaps
			.newConcurrentHashMap();

	private static final Comparator<Pair<Long, AccumulatedTimeStatsIdPb>> m_pairIndexComparator = new Comparator<Pair<Long, AccumulatedTimeStatsIdPb>>() {
		@Override
		public int compare(Pair<Long, AccumulatedTimeStatsIdPb> paramT1, Pair<Long, AccumulatedTimeStatsIdPb> paramT2) {
			return paramT1.getFirst() < paramT2.getFirst() ? -1 : 1;
		}
	};

	private static final Comparator<TimeProfileDimensionId> m_dimensionIdComparator = new Comparator<TimeProfileDimensionId>() {
		@Override
		public int compare(TimeProfileDimensionId paramT1, TimeProfileDimensionId paramT2) {
			return getNumberFromTimeProfileDimensionEnum(paramT1.getName())
					- getNumberFromTimeProfileDimensionEnum(paramT2.getName());
		}
	};

	private static int getNumberFromTimeProfileDimensionEnum(TimeProfileDimensionEnum value) {
		switch (value) {
		case CONTEXT:
			return 1;
		case CLASS:
			return 2;
		case METHOD:
			return 3;
		default:
			return 0;
		}
	}

	private TimeStatisticsFactory() {
	}

	private static Long getNewInsertId() {
		return m_id.getAndIncrement();
	}

	public static IAccumulator getInstance(AccumulatedTimeStatsIdPb accTimeStatsId) {
		AccumulatedTimeStatsIdPb id = getSortedAccumulatedDimensionId(accTimeStatsId);
		ValuesAccumulatorAndStatistics newValuesAccumulatorAndStatistics = new ValuesAccumulatorAndStatistics();
		IAccumulator value = s_instanceMap.putIfAbsent(id, newValuesAccumulatorAndStatistics);
		if (value != null) {
			return value;
		}
		Pair<Long, AccumulatedTimeStatsIdPb> idPair = new Pair<Long, AccumulatedTimeStatsIdPb>(getNewInsertId(), id);
		indexId(idPair);
		return s_instanceMap.get(id);
	}

	public static List<AccumulatedTimeStatsPb> getAcculmulatedTimeStatsList() {
		SortedSet<Pair<Long, AccumulatedTimeStatsIdPb>> sortedSet = Sets.newTreeSet(m_pairIndexComparator);
		if (s_indexMap.containsKey(TimeProfileDimensionEnum.CONTEXT)) {
			Collection<Set<Pair<Long, AccumulatedTimeStatsIdPb>>> accTimeStatsIdCollection = s_indexMap
					.get(TimeProfileDimensionEnum.CONTEXT).values();
			for (Set<Pair<Long, AccumulatedTimeStatsIdPb>> copyOnWriteArraySet : accTimeStatsIdCollection) {
				sortedSet.addAll(copyOnWriteArraySet);
			}
		}
		return getAccTimeStatsPbList(sortedSet);
	}

//	public static TimeProfileSearchRespPb getTimeProfileResponse() {
//		TimeProfileSearchRespPb.Builder builder = TimeProfileSearchRespPb.newBuilder();
//		List<AccumulatedTimeStatsPb> accumulatedTimeStatsList = getAcculmulatedTimeStatsList();
//		for (AccumulatedTimeStatsPb timeStats : accumulatedTimeStatsList) {
//			builder.addAccTimeStats(timeStats);
//		}
//		return builder.build();
//	}

	private static AccumulatedTimeStatsPb getAccumulatedTimeStatsPb(AccumulatedTimeStatsIdPb id,
			IAccumulator iAccumulator) {
		AccumulatedTimeStatsPb.Builder accStatsBuilder = AccumulatedTimeStatsPb
				.newBuilder(iAccumulator.getAccumulatedTimeStatsPb());
		// because its not working on Gwt side)
		// accStatsBuilder.mergeFrom(iAccumulator.getAccumulatedTimeStatsPb());//(commented
		accStatsBuilder.setName(getSortedAccumulatedDimensionId(id));
		return accStatsBuilder.build();
	}

	public static List<AccumulatedTimeStatsPb> getAcculmulatedTimeStatsList(AccumulatedTimeStatsIdPb id) {
		if (id.getDimensionIdCount() <= 0) {
			return getAcculmulatedTimeStatsList();
		}
		List<Set<Pair<Long, AccumulatedTimeStatsIdPb>>> list = Lists.newArrayList();
		for (TimeProfileDimensionId dimensionId : id.getDimensionIdList()) {
			list.add(getAcculmulatedTimeStatsIdPairList(dimensionId));
		}
		SortedSet<Pair<Long, AccumulatedTimeStatsIdPb>> sortedSet = getIntersection(list);
		return getAccTimeStatsPbList(sortedSet);
	}

	private static List<AccumulatedTimeStatsPb> getAccTimeStatsPbList(
			SortedSet<Pair<Long, AccumulatedTimeStatsIdPb>> set) {
		List<AccumulatedTimeStatsPb> accTimeStatsList = Lists.newArrayList();
		for (Pair<Long, AccumulatedTimeStatsIdPb> pair : set) {
			accTimeStatsList.add(getAccumulatedTimeStatsPb(pair.getSecond(), s_instanceMap.get(pair.getSecond())));
		}
		return accTimeStatsList;
	}

	private static SortedSet<Pair<Long, AccumulatedTimeStatsIdPb>> getIntersection(
			List<Set<Pair<Long, AccumulatedTimeStatsIdPb>>> collection) {
		if (collection.size() <= 0) {
			return new TreeSet<Pair<Long, AccumulatedTimeStatsIdPb>>();
		}
		SortedSet<Pair<Long, AccumulatedTimeStatsIdPb>> result = Sets.newTreeSet(m_pairIndexComparator);
		result.addAll(collection.get(0));
		for (Set<Pair<Long, AccumulatedTimeStatsIdPb>> item : collection) {
			result.retainAll(item);
		}
		return result;
	}

	private static Set<Pair<Long, AccumulatedTimeStatsIdPb>> getAcculmulatedTimeStatsIdPairList(
			TimeProfileDimensionId timeProfileDimensionId) {
		if (s_indexMap.containsKey(timeProfileDimensionId.getName())
				&& s_indexMap.get(timeProfileDimensionId.getName()).containsKey(timeProfileDimensionId.getValue())) {
			return s_indexMap.get(timeProfileDimensionId.getName()).get(timeProfileDimensionId.getValue());
		}
		return null;
	}

	private static AccumulatedTimeStatsIdPb getSortedAccumulatedDimensionId(AccumulatedTimeStatsIdPb key) {
		AccumulatedTimeStatsIdPb.Builder builder = AccumulatedTimeStatsIdPb.newBuilder();
		SortedSet<TimeProfileDimensionId> sortedSet = Sets.newTreeSet(m_dimensionIdComparator);
		sortedSet.addAll(key.getDimensionIdList());
		for (TimeProfileDimensionId dimensionId : sortedSet) {
			builder.addDimensionId(dimensionId);
		}
		return builder.build();
	}

	private static void indexId(Pair<Long, AccumulatedTimeStatsIdPb> idPair) {
		for (TimeProfileDimensionId dimensionId : idPair.getSecond().getDimensionIdList()) {
			ConcurrentMap<String, Set<Pair<Long, AccumulatedTimeStatsIdPb>>> idMap = ExtendedMaps
					.newConcurrentHashMap();
			s_indexMap.putIfAbsent(dimensionId.getName(), idMap);
			Set<Pair<Long, AccumulatedTimeStatsIdPb>> idSet = ExtendedSets.newConcurrentSet();
			s_indexMap.get(dimensionId.getName()).putIfAbsent(dimensionId.getValue(), idSet);
			s_indexMap.get(dimensionId.getName()).get(dimensionId.getValue()).add(idPair);
		}
	}
}
