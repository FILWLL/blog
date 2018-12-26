package com.hjljy.blog.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/24 0024 10:46
 * @Description: spring上下文注册中心 可以用于获取ApplicationContext对象 以及bean对象
 */
@Component
public class ApplicationContextRegister implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(ApplicationContextRegister.class);
    private static ApplicationContext applicationContext;

    /**
     * 设置spring  ApplicationContext上下文
     *
     * @param context
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        logger.debug("ApplicationContext ----- ", context);
        applicationContext = context;
    }

    /**
     * 获取ApplicationContext上下文容器
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取ApplicationContext上下文容器内对象
     *
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> type) {
        return applicationContext.getBean(type);
    }
}
