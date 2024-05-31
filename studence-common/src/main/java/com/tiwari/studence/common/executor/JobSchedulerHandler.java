package com.tiwari.studence.common.executor;

import com.tiwari.studence.common.interfaces.IThreadHandler;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobSchedulerHandler {
  /*private final ScheduledExecutorService scheduler;
  private List<JobSchedulerPb> jobList;

  public JobSchedulerHandler() {
    scheduler = Executors.newScheduledThreadPool(5); // You can configure the number of threads as needed.
  }

  public void start() {
    // Schedule a task to fetch the job list at regular intervals
    scheduler.scheduleAtFixedRate(this::fetchJobList, 0, 10, TimeUnit.MINUTES); // Adjust the interval as needed
  }

  private void fetchJobList() {
    // Fetch the updated job list from a data source (e.g., a database or an API)
    // Update the jobList field with the new data
    // jobList = fetchJobListFromDataSource();

    // Schedule and run the jobs from the updated list
    for (JobSchedulerPb job : jobList) {
      Runnable task = () -> {
        try {
          // Dynamically load and execute the class specified by className
          String className = job.getClassName();
          Class<?> handlerClass = Class.forName(className);
          IThreadHandler handler = (IThreadHandler) handlerClass.getDeclaredConstructor().newInstance();
          handler.run();
        } catch (Exception e) {
          e.printStackTrace();
        }
      };

      DurationEnum duration = job.getDuration();
      long delayMillis = 0;

      switch (duration) {
      case SECONDS:
        delayMillis = TimeUnit.SECONDS.toMillis(1);
        break;
      case MINUTES:
        delayMillis = TimeUnit.MINUTES.toMillis(1);
        break;
      case HOURS:
        delayMillis = TimeUnit.HOURS.toMillis(1);
        break;
      // Add more cases as needed for other DurationEnum values

      default:
        // Handle the default case or throw an exception
        break;
      }

      // Update lastRun and nextRun based on your logic
      // job.setLastRun(newTimestamp);
      // job.setNextRun(newTimestamp);
    }*/
  //}

}
