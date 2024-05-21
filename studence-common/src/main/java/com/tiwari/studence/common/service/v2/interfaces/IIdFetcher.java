package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.concurrent.atomic.AtomicLong;

public interface IIdFetcher {
  public IFuture<AtomicLong, ErrorException> getStartingId(final long size);
}
