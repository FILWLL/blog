package com.hjljy.blog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.mapper.system.AccountMapper;
import com.hjljy.blog.service.system.account.AccountService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Autowired
	AccountService service;
	@Test
	public void contextLoads() {
		boolean b = service.deleteById(15);
		System.out.println(b);
	}

}
