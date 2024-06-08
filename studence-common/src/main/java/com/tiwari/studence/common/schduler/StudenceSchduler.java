package com.tiwari.studence.common.schduler;

import com.tiwari.studence.proto.scheduler.SchedulerPb;
import com.tiwari.studence.proto.scheduler.TimeType;
import com.tiwari.studence.util.common.CommonUtil;
import com.tiwari.studence.util.exception.LoggedRuntimeException;
import com.tiwari.studence.util.log.DebugLogger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Date;

import static org.quartz.JobBuilder.newJob;

@Singleton
public class StudenceSchduler {

  private final Scheduler scheduler;

  @Inject
  public StudenceSchduler() {
    SchedulerFactory factory = new StdSchedulerFactory();
    try {
      scheduler = factory.getScheduler();
    } catch (SchedulerException e) {
      throw new LoggedRuntimeException("StudenceSchduler constructor", e.getStackTrace());
    }
  }

  public void scheduleTask(SchedulerPb pb, Class clazz) {
    if (pb.getTimeType() == TimeType.SINGLE) {
      Date scheduledTime = new Date(pb.getSingleTimeTask()); // Parse string to Date object
      JobDetail jobDetail = newJob(clazz).withIdentity(pb.getTaskName(), "single").build();
      // JobDetail jobDetail = JobBuilder.ofType(m_singleJob.getClass()).withIdentity(task, "single").build();
      jobDetail.getJobDataMap().put("taskName", pb.getTaskName()); // Add task name to JobDataMap
      Trigger trigger = TriggerBuilder.newTrigger().withIdentity(pb.getTaskName(), "single")
              .startAt(new Date(pb.getSingleTimeTask())).build();
      try {
        scheduler.scheduleJob(jobDetail, trigger);
      } catch (SchedulerException e) {
        throw new LoggedRuntimeException("StudenceSchduler ", e.getStackTrace());
      }
      DebugLogger.info("Scheduling task: " + pb.getTaskName() + " to execute at " + scheduledTime);
    } else if (pb.getTimeType() == TimeType.INTERVAL) {
      JobDetail jobDetail = newJob(clazz).withIdentity(pb.getTaskName(), "interval").build();
      jobDetail.getJobDataMap().put("taskName", pb.getTaskName()); // Add task name to JobDataMap
      Trigger trigger = TriggerBuilder.newTrigger().withIdentity(pb.getTaskName(), "interval")
              .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                      .withIntervalInMilliseconds(CommonUtil.toMillis(pb.getIntervalType()))
                      .repeatForever()).build();
      try {
        scheduler.scheduleJob(jobDetail, trigger);
      } catch (SchedulerException e) {
        throw new LoggedRuntimeException("StudenceSchduler ", e.getStackTrace());
      }
      //CronScheduleBuilder.cronSchedule(intervalType.getExpression())
      DebugLogger.info(
              "Scheduling task: " + pb.getTaskName() + " to execute with interval: " + pb.getIntervalType());
    } else {
      DebugLogger.error("Invalid time type specified.");
    }
  }

  public Scheduler getScheduler() {
    return scheduler;
  }

}
