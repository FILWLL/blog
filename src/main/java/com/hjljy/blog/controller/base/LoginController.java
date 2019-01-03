package com.hjljy.blog.controller.base;

import com.hjljy.blog.common.utils.MD5Util;
import com.hjljy.blog.common.utils.ShiroSessionUtil;
import com.hjljy.blog.service.system.account.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    public String loginIn(String username, String password, RedirectAttributes model){
        //输入密码进行加密之后在进行对比
        password = MD5Util.encrypt(password );
        System.out.println(password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            model.addFlashAttribute("msg",e.getMessage());
            return PATH_REDIRECT_LOGIN;
        }
        return PATH_REDIRECT_SYSTEM_INDEX;
    }

    /** 重定向到登录界面*/
    @GetMapping("/loginOut")
    public String loginOut(){
        ShiroSessionUtil.getSubjct().logout();
        return PATH_REDIRECT_LOGIN;
    }
}
