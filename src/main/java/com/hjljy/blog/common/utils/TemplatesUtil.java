package com.hjljy.blog.common.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/28 0028 15:43
 * @Description:
 */
public class TemplatesUtil {
    public static void create(String prefix,String suffix,String name,String content) {

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix(prefix);//模板所在目录，相对于当前classloader的classpath。
        resolver.setSuffix(suffix);//模板文件后缀
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        //构造上下文(Model)
        Context context = new Context();
        context.setVariable("content", content);
        //渲染模板
        FileWriter write = null;
        try {
            write = new FileWriter(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        templateEngine.process("tem", context, write);

    }

    public static String createHtml(String name,String content,String title) {

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");//模板所在目录，相对于当前classloader的classpath。
        resolver.setSuffix(".html");//模板文件后缀
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        //构造上下文(Model)
        Context context = new Context();
        context.setVariable("content", content);
        context.setVariable("title", title);
        File targetFile = new File("/var/html/");
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //渲染模板
        FileWriter write = null;
        try {
            write = new FileWriter("/var/html/"+name+".html");

            templateEngine.process("tem", context, write);
            write.close();
        } catch (IOException e) {
            System.out.println("错误信息1："+e.getMessage());
            e.printStackTrace();
        }
        return "/bloghtml/"+name+".html";
    }
}
