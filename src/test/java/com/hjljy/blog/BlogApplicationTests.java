package com.hjljy.blog;

import com.hjljy.blog.service.system.account.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Autowired
	AccountService service;
	@Test
	public void contextLoads() {
		//构造模板引擎
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setPrefix("templates/");//模板所在目录，相对于当前classloader的classpath。
		resolver.setSuffix(".html");//模板文件后缀
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(resolver);

		//构造上下文(Model)
		Context context = new Context();
		context.setVariable("name", "蔬菜列表");
		context.setVariable("array", new String[]{"hehe", "番茄", "白菜", "芹菜"});

		//渲染模板
		FileWriter write = null;
		try {
			write = new FileWriter("src/main/resources/static/html/result.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		templateEngine.process("tem", context, write);
	}

}
