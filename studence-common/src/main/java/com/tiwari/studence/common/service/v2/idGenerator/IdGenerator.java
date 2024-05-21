package com.tiwari.studence.common.service.v2.idGenerator;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tiwari.studence.common.async.IDoneCallback;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.async.SyncFuture;
import com.tiwari.studence.common.async.WaitOnFutureAndExecuteRunnableControlFlow;
import com.tiwari.studence.common.service.v2.interfaces.IIdEntityStore;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.encoder.Base64IntegerEncoder;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;
import com.tiwari.studence.util.exception.VoidException;


import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class IdGenerator<IdStore extends IIdEntityStore> {
  private static final int RANGE_SIZE = 100;
  private static final int THRESHOLD_SIZE = (int) (0.2 * RANGE_SIZE);

  private final IdRangeFetcher<IdStore> m_idRangeFetcher;
  private final Base64IntegerEncoder m_encoder;

  private Range m_currentRange;

  @Inject
  public IdGenerator(IdRangeFetcher<IdStore> idRangeFetcher, Base64IntegerEncoder encoder) {
    m_idRangeFetcher = idRangeFetcher;
    m_currentRange = new Range(null, 0, 0);
    m_encoder = encoder;
  }

  private IFuture<Range, VoidException> createNewRange() {
    final IFuture<AtomicLong, ErrorException> idStartFuture = m_idRangeFetcher.getStartingId(
            RANGE_SIZE);
    Callable<Range> createNewRangeCallable = new Callable<Range>() {
      @Override
      public Range call() throws Exception {
        return new Range(idStartFuture.get(), RANGE_SIZE, THRESHOLD_SIZE);
      }
    };
    return WaitOnFutureAndExecuteRunnableControlFlow.waitAndExecuteCallable(createNewRangeCallable,
            idStartFuture);
  }

  public IFuture<String, VoidException> getANewId() {
    final IFuture<Pair<Range, Boolean>, ErrorException> rangePairFuture = m_currentRange.getIdRange();
    Callable<String> idCallable = new Callable<String>() {
      @Override
      public String call() throws Exception {
        if (rangePairFuture.get().getSecond() == true) {
          m_currentRange = rangePairFuture.get().getFirst();
        }
        return rangePairFuture.get().getFirst().getId();
      }
    };
    return WaitOnFutureAndExecuteRunnableControlFlow.waitAndExecuteCallable(idCallable,
            rangePairFuture);
  }

  private class Range {
    private final AtomicLong m_startId;
    private final AtomicInteger m_remainingIds;
    private final int m_size;
    private final int m_threshold;
    private final Object m_lock = new Object();
    private IFuture<Range, VoidException> m_nextRangeFuture;

    public Range(AtomicLong startId, int size, int threshold) {
      Preconditions.check(size >= 0 && threshold >= 0);
      Preconditions.check(threshold <= size);
      m_size = size;
      m_threshold = threshold;
      if (m_size == m_threshold) {
        getNextRange();
      }
      m_remainingIds = new AtomicInteger(m_size);
      m_startId = startId;
    }

    private IFuture<Range, VoidException> getNextRange() {
      IFuture<Range, VoidException> rangeFuture = m_nextRangeFuture;
      if (rangeFuture != null) {
        return rangeFuture;
      }
      synchronized (m_lock) {
        rangeFuture = m_nextRangeFuture;
        if (rangeFuture != null) {
          return rangeFuture;
        }
        final IFuture<Range, VoidException> createdRangeFuture = createNewRange();
        m_nextRangeFuture = createdRangeFuture;
        createdRangeFuture.addDoneCallback(new IDoneCallback() {
          @Override
          public void done() {
            try {
              createdRangeFuture.get();
            } catch (Throwable e) {
              Preconditions.check(m_nextRangeFuture == createdRangeFuture);
              m_nextRangeFuture = null;
            }
          }
        });
        return createdRangeFuture;
      }
    }

    private IFuture<Pair<Range, Boolean>, ErrorException> getIdRange() {
      long requestNumber = m_remainingIds.decrementAndGet();
      if (requestNumber == m_threshold) {
        getNextRange();
      }
      if (requestNumber > 0) {
        return new SyncFuture<Pair<Range, Boolean>, ErrorException>(
                new Pair<Range, Boolean>(this, false));
      } else if (requestNumber == 0) {
        return new SyncFuture<Pair<Range, Boolean>, ErrorException>(
                new Pair<Range, Boolean>(this, true));
      }
      return getNextRange().get().getIdRange();
    }

    private String getId() {
      long id = m_startId.getAndIncrement();
      return m_encoder.convert((int) id);
    }
  }
}
