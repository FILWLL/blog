package com.hjljy.blog.service.blog;

import com.hjljy.blog.entity.blog.Blog;
import com.hjljy.blog.service.base.BaseService;

import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/27 0027 18:40
 * @Description:
 */
public interface BlogService extends BaseService<Blog> {

    /**
     * 根据博客id增加浏览次数
     * @param id
     */
    void setCountById(Integer id);

    List<String> getBlogTags();

    List<Blog> getTopBlog();
}
