package com.tiwari.studence.common.async;

import java.util.Map;

import com.google.inject.Key;
import com.tiwari.studence.proto.requestcontext.RequestContextPb;

public class RequestScopeHelper {
	public static void changeScopeIfRequired(Map<Key<?>, Object> newScope) {
		Map<Key<?>, Object> incomingThreadScopedObjectMap = getScopedObjectMap();
		if (incomingThreadScopedObjectMap == newScope) {
			return;
		}
		RequestScopes scope = RequestScopes.getInstance();
		if (incomingThreadScopedObjectMap != null) {
			scope.exit();
		}
		if (newScope != null) {
			scope.enter(newScope);
		}
		return;
	}

	public static void changeScope(Map<Key<?>, Object> newScope) {
		RequestScopes.getInstance().exit();
		if (newScope != null) {
			RequestScopes.getInstance().enter(newScope);
		}
	}

	public static RequestContextPb getRequestContext() {
		Key<RequestContextPb> key = Key.get(RequestContextPb.class);
		return RequestScopes.getInstance().getScopedValue(key);
	}

	public static Map<Key<?>, Object> getScopedObjectMap() {
		if (RequestScopes.getInstance().hasEntered()) {
			return RequestScopes.getInstance().getScopedObjectMap();
		}
		return null;
	}

	  public static void enterNewRequest(RequestContextPb context) {
	    if (RequestScopes.getInstance().hasEntered()) {
	      RequestScopes.getInstance().exit();
	    }
	    RequestScopes.getInstance().enter(null);
	    Key<RequestContextPb> key = Key.get(RequestContextPb.class);
	    RequestScopes.getInstance().getScopedObjectMap().put(key, context);
	  }
}
