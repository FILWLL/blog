package com.hjljy.blog.Quartz;

import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.service.system.account.AccountService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Auther: HJLJY
 * @Date: 2019/1/22 0022 17:07
 * @Description: 测试
 */
public class MyTask2 extends QuartzJobBean {

    //验证是否成功可以注入service   之前在ssm当中需要额外进行配置
    @Autowired
    private AccountService service;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("第二个定时任务执行结束————————"+new Date().toLocaleString());
    }
}
