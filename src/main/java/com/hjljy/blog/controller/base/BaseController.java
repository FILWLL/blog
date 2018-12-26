package com.hjljy.blog.controller.base;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/4 0004 17:41
 * @Description:
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/22 0022 09:39
 * @Description: 通用controller类
 *      包含：1. 日志logger
 */
public class BaseController<T> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected HttpServletRequest request;

    /** 重定向到login请求 */
    public static final String PATH_REDIRECT_LOGIN = "redirect:/login";
    /** 定向到登录界面*/
    public static final String PATH_LOGIN = "system/login";
    /** 重定向到后台入口请求 */
    public static final String PATH_REDIRECT_SYSTEM_INDEX="redirect:/system/index";
    /** 系统后台界面  */
    public static final String PATH_SYSTEM_INDEX="/system/index";
    /** 全局session用户*/
    public static final String USER_IN_SESSION="USER";

    public Page<T> getPage(int size, int limit){
        Page<T> page = new Page<>();
        page.setPageSize(size);
        page.setPageNum(limit);
        return page;
    }

}