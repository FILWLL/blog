package com.hjljy.blog.common.annotation;

import java.lang.annotation.*;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/25 0025 09:37
 * @Description: 日志自定义注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BlogLog {
    /**
     * 描述
     *
     * @return 描述信息
     */
    String description() default "";
}
