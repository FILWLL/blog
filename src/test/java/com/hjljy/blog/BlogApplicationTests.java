package com.hjljy.blog;

import com.hjljy.blog.entity.blog.Blog;
import com.hjljy.blog.mapper.blog.BlogMapper;
import com.hjljy.blog.service.blog.BlogService;
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
	BlogService service;

	@Autowired
	BlogMapper mapper;
	@Test
	public void contextLoads() {
		Example example = new Example(Blog.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.orLike("tags", "%spring%");
		example.and(criteria);
		List<Blog> blogs = mapper.selectByExample(example);
		System.out.println(1);
	}

}
