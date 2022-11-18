package com.tiwari.studence.shudence.util.cache;

public abstract class ACache<C extends ABaseCache, K extends Object, V extends Object> {
  private final String m_provider;
  private final C m_cache;

  public ACache(String provider, C cache) {
    m_provider = provider;
    m_cache = cache;
    cache.addLoader(provider, this);
  }

  protected abstract V load(K key);

  public V getUnchecked(K key) {
    return (V) m_cache.getUnchecked(m_provider, key);
  }

  public void invalidate(K key) {
    m_cache.invalidate(m_provider, key);
  }

  /**
   * 
   * @param key
   * @return Returns the value associated with key in this cache, or null if
   *         there is no cached value for key.
   */
  public V getIfPresent(K key) {
    return (V) m_cache.getIfPresent(m_provider, key);
  }
}
