package com.tiwari.studence.shudence.util.cache;

import java.util.List;
import java.util.Map;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tiwari.studence.util.Strings;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Preconditions;

public abstract class ABaseCache {
  private final LoadingCache<List<Object>, Object> m_cache;
  private final Map<String, ACache> m_cacheLoaderMap = Maps.newHashMap();

  public ABaseCache() {
    m_cache = initCache(newCacheLoader());
  }

  protected abstract LoadingCache<List<Object>, Object> initCache(
          CacheLoader<List<Object>, Object> cacheLoader);

  private CacheLoader<List<Object>, Object> newCacheLoader() {
    return new CacheLoader<List<Object>, Object>() {
      @Override
      public Object load(final List<Object> arg0) throws Exception {
        Object cacheData = m_cacheLoaderMap.get(arg0.get(0)).load(arg0.get(1));
        if (cacheData instanceof IFuture) {
          final IFuture<Object, ErrorException> future = (IFuture) cacheData;
          future.addDoneCallback(new IDoneCallback() {
            @Override
            public void done() {
              try {
                future.get();
              } catch (Throwable e) {
                invalidate(arg0.get(0).toString(), arg0.get(1));
              }
            }
          });
          return future;
        }
        return cacheData;
      }
    };

  }
  protected void addLoader(String provider, ACache loader) {
    Preconditions.validate(Strings.notEmpty(provider), "CacheProvider is empty for CacheLoader");
    Preconditions.validate(!m_cacheLoaderMap.containsKey(provider),
            "CacheLoader is already mapped for provider", provider);
    m_cacheLoaderMap.put(provider, loader);
  }

  protected Object getUnchecked(String provider, Object key) {
    return m_cache.getUnchecked(makeKey(provider, key));
  }

  protected void invalidate(String provider, Object key) {
    m_cache.invalidate(makeKey(provider, key));
  }

  protected Object getIfPresent(String provider, Object key) {
    return m_cache.getIfPresent(makeKey(provider, key));
  }

  private List<Object> makeKey(String provider, Object key) {
    Preconditions.validate(m_cacheLoaderMap.containsKey(provider),
            "CacheLoader is not contained for provider", provider);
    List<Object> keyObject = Lists.newArrayList(provider, key);
    return keyObject;
  }
}

