package com.hjljy.blog.Quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Auther: HJLJY
 * @Date: 2019/1/22 0022 17:07
 * @Description:
 */
public class MyTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //TODO 这里写定时任务的执行逻辑
        System.out.println("简单的定时任务执行时间："+new Date().toLocaleString());
    }
}
