package com.hjljy.blog.Quartz;

import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.mapper.system.AccountMapper;
import com.hjljy.blog.service.system.account.AccountService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Auther: HJLJY
 * @Date: 2019/1/22 0022 17:07
 * @Description:
 */
public class MyTask1 extends QuartzJobBean {

    //验证是否成功可以注入service   之前在ssm当中需要额外进行配置
    @Autowired
    private AccountService service;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Account account = new Account();
        account.setId(1);
        account = service.findByAccount(account);
        System.out.println(account.toString());
        //TODO 这里写定时任务的执行逻辑
        System.out.println("动态的定时任务执行时间："+new Date().toLocaleString());
    }
}
