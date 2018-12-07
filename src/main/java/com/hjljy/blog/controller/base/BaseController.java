package com.hjljy.blog.controller.base;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/4 0004 17:41
 * @Description:
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/22 0022 09:39
 * @Description: 通用controller类
 *      包含：1. 日志logger
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;

    /** 重定向到login请求 */
    public static final String PATH_REDIRECT_LOGOUT = "redirect:/login";
    /** 定向到登录界面*/
    public static final String PATH_LOGIN = "system/login";
    /** 重定向到后台入口请求 */
    public static final String PATH_REDIRECT_SYSTEM_INDEX="redirect:/system/index";
    /** 系统后台界面  */
    public static final String PATH_SYSTEM_INDEX="/system/index";
    /** 全局session用户*/
    public static final String USER_IN_SESSION="USER";


}