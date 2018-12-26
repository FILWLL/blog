package com.hjljy.blog.service.system.account;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.entity.system.AccountVO;
import com.hjljy.blog.mapper.system.AccountMapper;
import com.hjljy.blog.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo<AccountVO> getAccountVOByPage(Page page) {
        PageHelper.startPage(page.getPageSize(),page.getPageNum());
        return new PageInfo( mapper.getAccountVO());
    }
}
