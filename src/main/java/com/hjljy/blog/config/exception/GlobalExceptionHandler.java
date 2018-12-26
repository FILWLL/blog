package com.hjljy.blog.config.exception;

import com.hjljy.blog.common.AjaxJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : HJLJY
 * @since : 2018/11/26 0026 18:13
 * @Description: 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public AjaxJson doExceptionHandler(Exception e,HttpServletResponse rep){
        e.printStackTrace();
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.setFailMsg(e.toString());
        return  ajaxJson;
    }
}
