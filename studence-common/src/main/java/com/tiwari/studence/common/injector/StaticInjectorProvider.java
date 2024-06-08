package com.tiwari.studence.common.injector;

import com.google.inject.Injector;
import com.tiwari.studence.util.exception.Preconditions;

public class StaticInjectorProvider {
	  private static Injector s_injector;

	  public static void setInjector(Injector injector) {
	    Preconditions.check(s_injector == null && injector != null);
	    s_injector = injector;
	  }

	  public static Injector getInjector() {
	    Preconditions.check(s_injector != null);
	    return s_injector;
	  }
	}