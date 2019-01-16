package com.hjljy.blog.config.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: HJLJY
 * @Date: 2019/1/14 0014 14:10
 * @Description: 路径映射异常处理
 */
@Controller
public class MainsiteErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public Object handleError(HttpServletResponse response) {
        // 获取到响应状态码
        int status = response.getStatus();
        if (status == 401) {
            return new ModelAndView("/system/login");
        } else if (status == 403) {
            return new ModelAndView("/403");
        } else if (status == 404) {
            return new ModelAndView("/404");
        } else {
            return new ModelAndView("/error");
        }
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
