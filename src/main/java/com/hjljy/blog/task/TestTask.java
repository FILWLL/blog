package com.hjljy.blog.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: HJLJY
 * @Date: 2019/1/16 0016 10:52
 * @Description: 一个用于测试的定时任务
 */
@Component
public class TestTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Scheduled(cron = "0 10 *  * * ?")
    public void test1() {
        System.out.println("测试基于Scheduled的定时任务："+dateFormat.format(new Date()));
    }

}
