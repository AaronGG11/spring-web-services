// Source : https://www.baeldung.com/quartz
// Source : https://silo.tips/download/quartz-scheduler-example-programs-and-sample-code-version-221
// Source : https://www.quartz-scheduler.org/api/1.8.6/org/quartz/CronTrigger.html

package com.ks.pruebas.quartz.example1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//@SpringBootApplication
public class Example1Application
{
	public static void main(String[] args) throws SchedulerException, ParseException
	{
		//SpringApplication.run(Example1Application.class, args);

		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();

		JobDetail job = JobBuilder.newJob(SimpleJob.class)
				.withIdentity("myJob", "group1")
				.usingJobData("jobSays","Hello world!")
				.usingJobData("myFloatValue", 3.14f)
				.build();


		JobDetail jobA = JobBuilder
				.newJob(JobA.class)
				.withIdentity("jobA", "group2")
				.build();


		JobDetail jobB = JobBuilder
				.newJob(JobB.class)
				.withIdentity("jobB", "group2")
				.build();

		// simple trigger that executes each 15 seconds without priority
		Trigger trigger = TriggerBuilder
				.newTrigger().withIdentity("myTrigger", "group1")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(15)
						.repeatForever())
				.build();


		// simple trigger that executes each 10 seconds
		Trigger triggerA = TriggerBuilder
				.newTrigger()
				.withIdentity("triggerA", "group2")
				.startNow()
				.withPriority(15)
				.withSchedule(SimpleScheduleBuilder
						.simpleSchedule()
						.withIntervalInSeconds(10)
						.repeatForever())
				.build();


		// simple trigger that executes each 5 seconds
		Trigger triggerB = TriggerBuilder
				.newTrigger()
				.withIdentity("triggerB", "group2")
				.startNow().withPriority(10)
				.withSchedule(SimpleScheduleBuilder
						.simpleSchedule()
						.withIntervalInSeconds(5)
						.repeatForever())
				.build();


		// simple trigger that executes at 13:00 pm every week in MONDAY
		Trigger myTrigger1 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger1", "group3")
				.startNow()
				.withSchedule(CronScheduleBuilder
						.weeklyOnDayAndHourAndMinute(DateBuilder.MONDAY,13,6))
				.build(); // OK


		// simple trigger that executes at 2:00 PM every day
		Trigger myTrigger2 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger2", "group3")
				.startNow()
				.withSchedule(CronScheduleBuilder
						.dailyAtHourAndMinute(13,7))
				.build(); // OK

		// simple trigger that executes at 2:00 PM every 2 days, and it starts tomorrow
		Trigger myTrigger3 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger3", "group3")
				.startAt(DateBuilder.tomorrowAt(14,0,0))
				.withSchedule(CalendarIntervalScheduleBuilder
						.calendarIntervalSchedule()
						.withIntervalInDays(2))
				.build(); // OK


		// simple trigger that executes at 1:00 PM every month in 5th day
		Trigger myTrigger4 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger4", "group3")
				.startNow()
				.withSchedule(CronScheduleBuilder.monthlyOnDayAndHourAndMinute(17,13,10))
				.build(); // OK


		// simple trigger that executes at 6:00 PM every 6th December
		String startDateStr = "2020-08-17 13:16:15.0";
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(startDateStr);

		Trigger myTrigger5 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger5", "group3")
				.startAt(startDate)
				.withSchedule(CalendarIntervalScheduleBuilder
						.calendarIntervalSchedule()
						.withIntervalInYears(1))
				.build(); // OK


		// simple trigger that executes at 7:00 AM of last day of every each month
		/*
		The example provided by Quartz is :
			Expression: "0 15 10 L * ?"
			Meaning: Fire at 10:15am on the last day of every month
		*/
		Trigger myTrigger6 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger6", "group3")
				.startNow()
				.withSchedule(CronScheduleBuilder
						.cronSchedule("0 15 10 L * ?"))
				.build(); // HOW CAN I TEST THIS ?


		// simple trigger that excecutes at 10:15 AM every day during the year 2020

		Trigger myTrigger7 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger7", "group3")
				.startNow()
				.withSchedule(CronScheduleBuilder
				.cronSchedule("0 21 13 * * ? 2020"))
				.build(); // OK


		// simple trigger that excecutes between 13:00 AM and 13:50 PM every day
		Trigger myTrigger8 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger8", "group3")
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0-50,33 13 * * ?"))
				.build(); // OK


		// simple trigger that excecutes at 13:55 PM on weekdays (MONDAY TO FRIDAY)
		Trigger myTrigger9 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger9", "group3")
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0 40 13 ? * MON-FRI"))
				.build(); // OK

		// simple trigger that excecutes at 13:45 PM on the 17th day of every mont
		Trigger myTrigger10 = TriggerBuilder
				.newTrigger()
				.withIdentity("myTrigger10", "group3")
				.startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0 43 13 17 * ?"))
				.build(); // OK


		//scheduler.scheduleJob(job, trigger);
		scheduler.scheduleJob(jobA, myTrigger10);
		//scheduler.scheduleJob(jobB, triggerB);

		scheduler.start();
	}
}



