package com.hjljy.blog.service.blog;

import com.hjljy.blog.entity.blog.Blog;
import com.hjljy.blog.mapper.blog.BlogMapper;
import com.hjljy.blog.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/27 0027 18:40
 * @Description:
 */
@Service
public class BlogServiceImpl extends BaseServiceImpl<Blog> implements BlogService  {

    private final BlogMapper blogMapper;

    public BlogServiceImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public void setCountById(Integer id) {
        blogMapper.setCountById(id);
    }

    @Override
    public List<String> getBlogTags() {
        return blogMapper.getBlogTags();
    }

    @Override
    public List<Blog> getTopBlog() {
        return blogMapper.getTopBlog();
    }
}
