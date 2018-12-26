package com.hjljy.blog.common.utils;

import com.hjljy.blog.entity.system.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/24 0024 13:41
 * @Description:  针对shiro的session工具类  用于session的获取和设置
 */
public class ShiroSessionUtil {

    /**
     * 用户信息key
     */
    public static final String USER_SESSION_KEY = "USER_SESSION_KEY";

    /**
     * 获取shiro的Subject对象
     * @return
     */
    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取shiro当中的session对象
     * @return
     */
    public static Session getSession(){
        return getSubjct().getSession();
    }

    /**
     * 获取Shiro当中session的用户信息
     * @return
     */
    public static Account getAccount(){
        return (Account) getSession().getAttribute(USER_SESSION_KEY);
    }

    /**
     * 获取Shiro当中session的用户名称
     * @return
     */
    public static String getAccountName(){
        return getAccount().getUsername();
    }

    /**
     * 设置Shiro当中的session用户信息
     * @param account
     */
    public static void setSession(Account account){
        getSession().setAttribute(USER_SESSION_KEY, account);
    }
}
