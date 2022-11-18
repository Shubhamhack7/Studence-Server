package com.tiwari.studence.common.async;

import java.util.concurrent.CountDownLatch;

public class DoneLatch extends CountDownLatch{
	  public DoneLatch() {
	    super(1);
	  }

	  public void done() {
	    this.countDown();
	  }

	  @Override
	  public void await() {
	    try {
	      super.await();
	    } catch (InterruptedException e) {
	      throw new RuntimeException(e);
	    }
	  }
//		private boolean done = false;
	//
//		  public void done() {
//		    done = true;
//		  }
	//
//		  public void await() {
//		    if (!done) {
//		      throw new RuntimeException("Await called before Done.");
//		    }
//		  }
	}
