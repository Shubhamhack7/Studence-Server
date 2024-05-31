package com.tiwari.studence.util.common;

import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudenceLoggingRunnable implements Runnable {

  private static final ThreadLocal<Logger> threadLogger = new ThreadLocal<Logger>() {
    @Override
    protected Logger initialValue() {
      return LogManager.getLogger(Thread.currentThread().getName());
    }
  };

  public static Logger getLogger() {
    return threadLogger.get();
  }

  @Override
  public void run() {
    Logger logger = getLogger();
    logger.info("Thread started: " + Thread.currentThread().getName()); // Log thread start

    try {
      doRun(); // Perform the actual task logic
      logger.info(
              "Thread completed successfully: " + Thread.currentThread().getName()); // Log success
    } catch (Exception e) {
      logger.error("Thread encountered an error: " + Thread.currentThread().getName(),
              e); // Log errors
      try {
        throw new LoggedRuntimeException(
                new ErrorException(e)); // Rethrow the exception to handle it appropriately
      } catch (Exception ex) {
        throw new RuntimeException(ex);
      }
    }
  }

  protected void doRun() throws Exception {

  }

}