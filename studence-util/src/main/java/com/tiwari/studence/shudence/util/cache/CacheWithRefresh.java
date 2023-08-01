package com.tiwari.studence.shudence.util.cache;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.Singleton;

@Singleton
public class CacheWithRefresh extends ABaseCache {

  @Override
  protected LoadingCache<List<Object>, Object> initCache(
          CacheLoader<List<Object>, Object> cacheLoader) {
    return CacheBuilder.newBuilder().maximumSize(10000).refreshAfterWrite(15, TimeUnit.MINUTES)
            .expireAfterAccess(10, TimeUnit.MINUTES).build(cacheLoader);
  }

}