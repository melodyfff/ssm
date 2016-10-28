package com.xinchen.ssm.quartz.demo;

/**
 * Description：
 * Created by ChenXin on 2016/10/28.
 */
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloJob implements Job {
    Logger log = LoggerFactory.getLogger(HelloJob.class);
    public void execute(JobExecutionContext context)throws JobExecutionException {
        System.out.println("Hello World! --------------------------- " + new Date());
    }
}
