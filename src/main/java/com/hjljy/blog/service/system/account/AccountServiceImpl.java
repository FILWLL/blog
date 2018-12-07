package com.hjljy.blog.service.system.account;

import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.mapper.system.AccountMapper;
import com.hjljy.blog.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/3 0003 17:56
 * @Description:
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
    private final AccountMapper mapper;

    @Autowired
    public AccountServiceImpl(AccountMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Account findByAccount(Account account) {
        return mapper.selectOne(account);
    }
}
