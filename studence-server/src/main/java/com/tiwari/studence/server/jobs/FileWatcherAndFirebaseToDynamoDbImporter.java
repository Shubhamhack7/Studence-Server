package com.tiwari.studence.server.jobs;

import com.tiwari.studence.util.log.DebugLogger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class FileWatcherAndFirebaseToDynamoDbImporter implements Job {
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    String taskName = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("taskName");
    DebugLogger.info("Executing interval task: " + taskName);
  }
}
