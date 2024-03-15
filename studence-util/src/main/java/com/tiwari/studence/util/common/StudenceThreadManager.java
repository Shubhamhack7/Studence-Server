package com.tiwari.studence.util.common;

import com.tiwari.studence.util.log.DebugLogger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class StudenceThreadManager {

  public enum ThreadTypeEnum {
    CONCURRENT,
    NON_CONCURRENT
  }

  public enum ThreadStateEnum {
    START,
    PROCESSING,
    END
  }

  private final BlockingQueue<Runnable> tasks;
  private final ThreadFactory threadFactory;
  private final Map<Class<?>, Boolean> waitForCompletionMap;

  public StudenceThreadManager(ThreadFactory threadFactory) {
    this.tasks = new LinkedBlockingQueue<>();
    this.threadFactory = threadFactory != null ? threadFactory : new DefaultThreadFactory();
    this.waitForCompletionMap = new HashMap<>();
  }

  public void setWaitForCompletion(Class<?> taskClass, boolean waitForCompletion) {
    waitForCompletionMap.put(taskClass, waitForCompletion);
  }

  public void submitTask(Runnable task, ThreadTypeEnum threadType)
          throws InterruptedException, IllegalStateException {
    AtomicReference<ThreadStateEnum> threadState = new AtomicReference<>(ThreadStateEnum.START);
    Class<?> taskClass = task.getClass();
    tasks.put(() -> {
      synchronized (taskClass) {
        Boolean waitForCompletion = waitForCompletionMap.get(taskClass);
        if (waitForCompletion != null && waitForCompletion && threadType == ThreadTypeEnum.CONCURRENT) {
          while (Thread.holdsLock(taskClass)) {
            try {
              taskClass.wait();
            } catch (InterruptedException e) {
              // Handle interruption gracefully (e.g., stop processing)
              break;
            }
          }
        } else if (waitForCompletion != null && !waitForCompletion && threadType == ThreadTypeEnum.CONCURRENT) {
          if (Thread.holdsLock(taskClass)) {
            throw new IllegalStateException(
                    "Concurrent execution detected for class " + taskClass.getName());
          }
        }
        try {
          threadState.set(ThreadStateEnum.PROCESSING);
          DebugLogger.info(
                  "Task Run:" + taskClass.getName() + " State - " + threadState.get().name());
          task.run();
        } finally {
          synchronized (taskClass) {
            taskClass.notify();
          }
          threadState.set(ThreadStateEnum.END);
          DebugLogger.info(
                  "Task Run:" + taskClass.getName() + " State - " + threadState.get().name());
        }
      }
    });
  }

  public void start() {
    Thread managerThread = threadFactory.newThread(() -> {
      while (!Thread.interrupted()) {
        try {
          Runnable nextTask = tasks.take();
          nextTask.run();
        } catch (InterruptedException e) {
          // Handle interruption gracefully (e.g., stop processing)
          break;
        } catch (IllegalStateException e) {
          // Handle concurrency exception for Class B (optional: log or notify)
          System.err.println(e.getMessage()); // Example: log the error
        }
      }
    });
    managerThread.start();
  }

  public void shutdown() {
    tasks.clear(); // Interrupt waiting threads
  }

  private static class DefaultThreadFactory implements ThreadFactory {
    private int threadNum = 0;

    @Override
    public Thread newThread(Runnable r) {
      Thread thread = new Thread(r, "StudenceThreadManager-Thread-" + threadNum++);
      thread.setDaemon(true); // Set thread as daemon (exits when main thread exits)
      return thread;
    }
  }
}
