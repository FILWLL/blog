package com.hjljy.blog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/27 0027 16:39
 * @Description:  将上传资源添加到
 */
@Component
public class WebConfigurer implements WebMvcConfigurer {

    @Value("${hjljy-upload-path}")
    private  String uploadPath;

    @Value("${hjljy-blog-path}")
    private  String blogPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**").addResourceLocations("file://"+uploadPath);
        registry.addResourceHandler("/bloghtml/**").addResourceLocations("file://"+blogPath);
    }

}
