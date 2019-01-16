package com.hjljy.blog.config.exception;

import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.common.utils.HttpServletRequestUtil;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : HJLJY
 * @since : 2018/11/26 0026 18:13
 * @Description: 全局异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(AuthorizationException.class)
    public Object doAuthorizationException(AuthorizationException  e , HttpServletRequest request){
        logger.error(e.getMessage(),e);
        if(HttpServletRequestUtil.isAjax(request)){
            AjaxJson ajaxJson = new AjaxJson();
            ajaxJson.setFailMsg("没有操作权限");
            return  ajaxJson;
        }

        return  new ModelAndView("/403");
    }


    @ExceptionHandler
    public Object doExceptionHandler(Exception e,HttpServletRequest request){
        logger.error(e.getMessage(),e);
        if(HttpServletRequestUtil.isAjax(request)){
            AjaxJson ajaxJson = new AjaxJson();
            ajaxJson.setFailMsg("内部服务器错误");
            return  ajaxJson;
        }
        return  new ModelAndView("/error");
    }
}
