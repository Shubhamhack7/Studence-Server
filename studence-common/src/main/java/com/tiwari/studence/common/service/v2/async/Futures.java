package com.tiwari.studence.common.service.v2.async;

import com.tiwari.studence.common.async.IFuture;
import com.tiwari.studence.util.collect.Lists;
import com.tiwari.studence.util.exception.ErrorException;
import com.tiwari.studence.util.exception.Exceptions;
import com.tiwari.studence.util.exception.VoidException;

import java.util.List;

public class Futures {
  public static <R> List<R> getResultList(List<IFuture<R, VoidException>> futures) {
    List<R> resultList = Lists.newArrayList();
    for (IFuture<R, VoidException> resultFuture : futures) {
      R result = resultFuture.get();
      resultList.add(result);
    }
    return resultList;
  }

  /**
   * This utility function can be used to make sure asynchronous futures that
   * don't return a value and are not expected to throw Exception didn't throw
   * an unexpected exception.
   */
  public static void invokeGet(IFuture<?, ?>... futures) {
    try {
      for (int i = 0; i < futures.length; ++i) {
        futures[i].get();
      }
    } catch (Throwable t) {
      throw Exceptions.handleThrowable(t);
    }
  }

  public static void invokeGet(List<IFuture<?, ?>> futures) {
    try {
      for (IFuture<?, ?> future : futures) {
        future.get();
      }
    } catch (Throwable t) {
      throw Exceptions.handleThrowable(t);
    }
  }

  public static void invokeEEGet(List<IFuture<?, ?>> futures) throws ErrorException {
    try {
      for (IFuture<?, ?> future : futures) {
        future.get();
      }
    } catch (Throwable t) {
      if (t instanceof ErrorException) {
        throw (ErrorException) t;
      }
      throw Exceptions.handleThrowable(t);
    }
  }

  public static void invokeEEGet(IFuture<?, ?>... futures) throws ErrorException {
    try {
      for (int i = 0; i < futures.length; ++i) {
        futures[i].get();
      }
    } catch (Throwable t) {
      if (t instanceof ErrorException) {
        throw (ErrorException) t;
      }
      throw Exceptions.handleThrowable(t);
    }
  }
}