package com.hjljy.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * @Auther: HJLJY
 * @Date: 2019/1/16 0016 14:44
 * @Description: 基于Schedule定时任务多线程设置
 */
@Configuration
public class ScheduleConfig  implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //设置线程池大小
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
    }
}
