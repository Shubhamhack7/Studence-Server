package com.tiwari.studence.common.service.v2.idGenerator;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tiwari.studence.common.async.IBatchAsyncCall;
import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.common.service.v2.interfaces.IAsyncCallCreator;
import com.tiwari.studence.common.service.v2.interfaces.IIdEntityStore;
import com.tiwari.studence.common.service.v2.interfaces.IIdFetcher;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class IdRangeFetcher<IdStore extends IIdEntityStore> implements IIdFetcher {
  private final IdStore m_idStoreManager;
  private final ExponentialBackoffAsyncCallScheduler m_retryableExecutor;

  @Inject
  public IdRangeFetcher(IdStore idStoreManager,
          ExponentialBackoffAsyncCallScheduler retryableExecutor) {
    m_idStoreManager = idStoreManager;
    m_retryableExecutor = retryableExecutor;
  }

  @Override
  public IFuture<AtomicLong, ErrorException> getStartingId(final long size) {
    IAsyncCallCreator<AtomicLong, ErrorException> idCallCreator = new IAsyncCallCreator<AtomicLong, ErrorException>() {
      @Override
      public IBatchAsyncCall<AtomicLong, ErrorException> createAsyncCall() {
        return new IdLookupControlFlow(m_idStoreManager, size);
      }
    };
    return m_retryableExecutor.scheduleCall(idCallCreator);
  }
}
