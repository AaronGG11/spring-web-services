package com.ks.pruebas.quartz.example1;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobExecutionContext;

public class SimpleJob implements Job
{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
    {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        String jobSays = jobDataMap.getString("jobSays");
        float myFloatValue = jobDataMap.getFloat("myFloatValue");

        System.out.println("Job says: " + jobSays + ", and value is: " + myFloatValue);
    }
}
