package com.xinchen.ssm.quartz.demo;

/**
 * Description：
 * Created by ChenXin on 2016/10/28.
 */

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;

public class SimpleExample {
    public void run() throws Exception {
        System.out.println("------- 初始化 ----------------------");
        //通过工厂获取Scheduler
        Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
        System.out.println("------- 初始化完成 -----------");
        Date runTime = DateBuilder.evenMinuteDate(new Date());
        System.out.println("------- 将Job加入Scheduler中  -------------------");
        //构建一个作业实例
        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("job1234", "group1234").build();

        //TriggerBuilder实例化一个触发器
        Trigger trigger = TriggerBuilder.newTrigger()//创建一个新的TriggerBuilder用来规范一个触发器
                .withIdentity("trigger1234", "group1234")//给触发器一个名字和组名
                .withSchedule(
                        cronSchedule("*/5 * * * * ?").
                        withMisfireHandlingInstructionFireAndProceed()  //or other
                )
                .startNow()
                .startAt(runTime)//设置触发开始的时间
                .build();//产生触发器


        sched.scheduleJob(job, trigger);//向Scheduler添加一个job和trigger
        System.out.println(job.getKey() + " 运行在: " + runTime);

        sched.start();

        System.out.println("------- Scheduler调用结束 -----------------");

        System.out.println("------- 等待5S... -------------");
        try {
            Thread.sleep(15000L);
        } catch (Exception e) {
        }

        System.out.println("------- Scheduler关闭 -----------------");
        sched.shutdown(true);
        System.out.println("------- Scheduler完成 -----------------");
    }

    public static void main(String[] args) throws Exception {
        SimpleExample example = new SimpleExample();
        example.run();
    }
}
