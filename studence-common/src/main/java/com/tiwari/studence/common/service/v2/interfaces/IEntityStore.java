package com.tiwari.studence.common.service.v2.interfaces;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.exception.ErrorException;

import java.util.Map;
import java.util.Set;

public interface IEntityStore<R> {
  public IFuture<R, ErrorException> lookupEntity(String id);

  /**
   * It takes care for generating an id and taking care of entity proto semantics.
   */
  public IFuture<R, ErrorException> insertEntity(R entity);

  /**
   * It takes care of entity proto semantics and increasing version.
   */
  public IFuture<R, ErrorException> updateEntity(R entity);

  /**
   * It takes care of entity proto semantics and increasing version. It doesn't actually deletes
   * entity but marks it as deleted.
   */
  public IFuture<R, ErrorException> deleteEntity(R entity);

  /**
   * It takes care for generating an id and taking care of entity proto semantics.
   */
  @Deprecated
  public IFuture<R, ErrorException> insertEntity(String requestId, R entity);

  /**
   * It takes care of entity proto semantics and increasing version.
   */
  @Deprecated
  public IFuture<R, ErrorException> updateEntity(String requestId, R entity);

  /**
   * It takes care of entity proto semantics and increasing version. It doesn't actually deletes
   * entity but marks it as deleted.
   */
  @Deprecated
  public IFuture<R, ErrorException> deleteEntity(String requestId, R entity);

  public IFuture<Pair<Set<String>, Map<String, R>>, ErrorException> batchGetItem(
          Set<String> idList);

}

