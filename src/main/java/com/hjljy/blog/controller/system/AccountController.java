package com.hjljy.blog.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/15 0015 18:45
 * @Description:
 */
@Controller
public class AccountController {

    @GetMapping("/index")
    public String index() {
        System.out.println(1);
        return "system/Account";
    }
}
