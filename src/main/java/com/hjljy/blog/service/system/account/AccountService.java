package com.hjljy.blog.service.system.account;

import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.service.base.BaseService;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/29 0029 11:03
 * @Description:
 */
public interface AccountService extends BaseService<Account> {

    Account findByAccount(Account account);
}
