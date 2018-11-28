package com.hjljy.blog.controller;

import com.hjljy.blog.common.AjaxJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/27 0027 11:24
 * @Description:
 */
@Controller
public class TestController {


    @RequestMapping("/test")
    public String test(){
        AjaxJson ajaxJson = new AjaxJson();
        int i = 1/0;
        ajaxJson.setSuccess(true);
        return "afaagags";
    }
}
