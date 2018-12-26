package com.hjljy.blog.service.system.account;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.entity.system.AccountVO;
import com.hjljy.blog.service.base.BaseService;

import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/29 0029 11:03
 * @Description:
 */
public interface AccountService extends BaseService<Account> {
    /**
     * 根据用户信息进行查找
     * @param account
     * @return
     */
    Account findByAccount(Account account);

    /**
     * 获取界面分页展示数据
     * @param page
     * @return
     */
    PageInfo<AccountVO> getAccountVOByPage(Page page);
}
