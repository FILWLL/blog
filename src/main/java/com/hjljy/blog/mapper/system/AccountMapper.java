package com.hjljy.blog.mapper.system;

import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    List<Account> getAccountVO();
}