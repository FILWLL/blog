package com.hjljy.blog.controller;

import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/27 0027 11:24
 * @Description:
 */
@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public String test(){
        AjaxJson ajaxJson = new AjaxJson();
        try {
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        ajaxJson.setSuccess(true);
        return "afaagags";
    }


}
