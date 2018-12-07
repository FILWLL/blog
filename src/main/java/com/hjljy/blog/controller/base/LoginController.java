package com.hjljy.blog.controller.base;

import com.hjljy.blog.controller.base.BaseController;
import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.service.system.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/4 0004 17:37
 * @Description:
 */
@Controller
public class LoginController extends BaseController {
    private final AccountService service;

    @Autowired
    public LoginController(AccountService service) {
        this.service = service;
    }

    /** 跳转到登录界面*/
    @GetMapping("/login")
    public String index(){
        return PATH_LOGIN;
    }

    /**处理登录请求*/
    @PostMapping("/loginIn")
    public String loginIn(Account account, RedirectAttributes model){
        Account user = service.findByAccount(account);
        if (user==null){
            model.addAttribute("msg", "账号密码不正确：请检查用户名和密码");
            return PATH_REDIRECT_LOGOUT;
        }
        request.getSession().setAttribute(USER_IN_SESSION, user);
        return PATH_REDIRECT_SYSTEM_INDEX;
    }

    /** 重定向到登录界面*/
    @GetMapping("/loginOut")
    public String loginOut(){
        return PATH_REDIRECT_LOGOUT;
    }
}
