package com.tiwari.studence.app.module;

import com.tiwari.studence.common.schduler.StudenceSchduler;
import com.tiwari.studence.proto.scheduler.IntervalType;
import com.tiwari.studence.proto.scheduler.SchedulerPb;
import com.tiwari.studence.proto.scheduler.TimeType;
import com.tiwari.studence.server.jobs.FileWatcherAndFirebaseToDynamoDbImporter;
import com.tiwari.studence.util.common.StudenceLoggingRunnable;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import org.apache.logging.log4j.Logger;
import org.quartz.SchedulerException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StudenceSchedulerModule extends StudenceLoggingRunnable {

  private StudenceSchduler m_studenceSchduler;

  @Inject
  public StudenceSchedulerModule() {
    m_studenceSchduler = new StudenceSchduler();
    scheduleJobs();
  }

  private void scheduleJobs() {
    m_studenceSchduler.scheduleTask(
            getPb("File Watcher And Firebase To Dynamo Database Importer", "", TimeType.INTERVAL,
                    IntervalType.SECONDS), FileWatcherAndFirebaseToDynamoDbImporter.class);
  }

  private SchedulerPb getPb(String taskName, String singleTaskTime, TimeType timeType,
          IntervalType intervalType) {
    SchedulerPb.Builder pb = SchedulerPb.newBuilder();
    pb.setTaskName(taskName);
    pb.setTimeType(timeType);
    pb.setIntervalType(intervalType);
    pb.setSingleTimeTask(singleTaskTime);
    return pb.build();
  }

  @Override
  protected void doRun() throws Exception {
    try {
      Logger logger = getLogger();
      logger.info("Message from thread: " + Thread.currentThread().getName());
      m_studenceSchduler.getScheduler().start();
    } catch (SchedulerException e) {
      throw new LoggedRuntimeException("Studence Schduler Start error", e.getStackTrace());
    }
  }
}
