package com.hjljy.blog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjljy.blog.mapper.system.AccountMapper;
import com.hjljy.blog.pojo.system.Account;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {
	@Autowired
	private  AccountMapper accountMapper;

	@Test
	public void contextLoads() {
        List<Account> select = accountMapper.select(new Account());
		select.forEach(account -> System.out.println(account) );
		PageInfo<Account> objects = PageHelper.startPage(1, 3).doSelectPageInfo(()->this.accountMapper.selectAll());
		PageHelper.startPage(1, 3);
        List<Account> accounts = accountMapper.selectAll();
        PageInfo<Account> accountPageInfo = new PageInfo<>(accounts);
         System.out.println(objects.toString());
    }

}
