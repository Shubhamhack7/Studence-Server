package com.tiwari.studence.common.async;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;

public class RequestScopes implements Scope {
	  private final ThreadLocal<Map<Key<?>, Object>> values = new ThreadLocal<Map<Key<?>, Object>>();

	  private static final RequestScopes REQUEST_SCOPE = new RequestScopes();

	  private RequestScopes() {
	  }

	  public final static RequestScopes getInstance() {
	    return REQUEST_SCOPE;
	  }

	  public void enter() {
	    values.set(new HashMap<Key<?>, Object>());
	  }

	  public void enter(Map<Key<?>, Object> map) {
	    // Preconditions.check(values.get() == null, "A scoping block is already in
	    // progress");
	    if (map == null) {
	      map = new HashMap<Key<?>, Object>();
	    }
	    values.set(map);
	  }

	  public boolean hasEntered() {
	    return values.get() != null;
	  }

	  public void exit() {
	    // Preconditions.check(values.get() != null, "No scoping block in
	    // progress");
	    values.remove();
	  }

	  public <T> Provider<T> scope(final Key<T> key, final Provider<T> unscoped) {
	    // Preconditions.check(unscoped != null, "Unscoped should not be null",
	    // key);
	    return new Provider<T>() {
	      public T get() {
	        if (!hasEntered()) {
	          return null;
	        }
	        Map<Key<?>, Object> scopedObjects = getScopedObjectMap();
	        if (!scopedObjects.containsKey(key)) {
	          synchronized (scopedObjects) {
	            if (!scopedObjects.containsKey(key)) {
	              T val = unscoped.get();
	              // Preconditions.check(val != null, "unscoped val should not be
	              // null", key);
	              scopedObjects.put(key, val);
	            }
	          }
	        }
	        return (T) scopedObjects.get(key);
	      }
	    };
	  }

	  public <T> T getScopedValue(final Key<T> key) {
	    if (!hasEntered()) {
	      return null;
	    }
	    Map<Key<?>, Object> scopedObjects = getScopedObjectMap();
	    if (!scopedObjects.containsKey(key)) {
	      return null;
	    }
	    return (T) scopedObjects.get(key);
	  }

	  public <T> Map<Key<?>, Object> getScopedObjectMap() {
	    Map<Key<?>, Object> scopedObjects = values.get();
	    // Preconditions.check(scopedObjects != null, "Scope has not started");
	    return scopedObjects;
	  }
	}
