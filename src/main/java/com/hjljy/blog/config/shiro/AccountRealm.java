package com.hjljy.blog.config.shiro;

import com.hjljy.blog.common.ApplicationContextRegister;
import com.hjljy.blog.common.utils.ShiroSessionUtil;
import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.service.system.account.AccountService;
import com.hjljy.blog.service.system.resources.ResourcesService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/21 0021 17:30
 * @Description: 自定义认证类，负责自己的认证跳转
 */
public class AccountRealm extends AuthorizingRealm {
    /**
     * 进行授权操作，获取到对应用户的权限进行放行
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        ResourcesService service = ApplicationContextRegister.getBean(ResourcesService.class);
        Set<String> perms = service.getPermsByUserId(ShiroSessionUtil.getAccount().getId());
        //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;
    }

    /**
     * 进行认证操作 将输入的用户信息和数据库用户信息进行对比
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        Account user = new Account(username,password);
        //通过spring上下文获取到service对象
        AccountService service = ApplicationContextRegister.getBean(AccountService.class);
        user = service.findByAccount(user);
        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        // 账号锁定
        if (!user.getStatus()) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        ShiroSessionUtil.setSession(user);
        return info;
    }
}
