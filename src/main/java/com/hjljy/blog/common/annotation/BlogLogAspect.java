package com.hjljy.blog.common.annotation;

import com.hjljy.blog.common.utils.ShiroSessionUtil;
import com.hjljy.blog.entity.system.Log;
import com.hjljy.blog.service.system.log.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/25 0025 09:48
 * @Description: 基于AOP技术的日志操作
 */
@Aspect
@Component
public class BlogLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(BlogLogAspect.class);

    @Autowired
    private LogService logService;

    @Autowired
    private HttpServletRequest request;

    /**
     *定义一个切点
     */
    @Pointcut("@annotation(com.hjljy.blog.common.annotation.BlogLog)")
    public void logPointCut() {
    }

    /**
     * 环绕通知 针对切点开始以及完毕做出相关信息记录
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveBlogLog(point, time);
        return result;
    }

    void saveBlogLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log sysLog = new Log();
        BlogLog blogLog = method.getAnnotation(BlogLog.class);
        if (blogLog != null) {
            //设置操作的描述
            sysLog.setOperationDesc(blogLog.description());
        }
        //设置操作方法
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setOperationMethod(className + "." + methodName + "()");
        // 设置操作的IP地址
        sysLog.setOperationIp(request.getRemoteAddr());
        // 设置用户信息
        sysLog.setUserId(ShiroSessionUtil.getAccount().getId());
        sysLog.setUserName(ShiroSessionUtil.getAccountName());
        //设置操作
        sysLog.setResponseTime((int) time);
        // 系统当前时间
        Date date = new Date();
        sysLog.setOperationTime(date);
        // 保存系统日志
        logService.insertSelective(sysLog);
    }
}
