package com.hjljy.blog.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 10:38
 * @Description:
 */
@Controller
public class IndexController extends BaseController{



    @GetMapping("/system/index")
    public String index(Model model){
        return "system/index";
    }


}
