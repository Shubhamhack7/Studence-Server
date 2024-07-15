package com.tiwari.studence.common.executor;

public class StudenceThreadExecuter {
  public enum ThreadExecutionMode {
    BACKGROUND,
    FOREGROUND
  }

  public static void execute(ThreadExecutionMode mode, Runnable task) {
    if (mode == ThreadExecutionMode.FOREGROUND) {
      task.run();
    } else {
      new Thread(task).start();
    }
  }
}
