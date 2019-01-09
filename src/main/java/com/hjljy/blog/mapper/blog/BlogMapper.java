package com.hjljy.blog.mapper.blog;

import com.hjljy.blog.entity.blog.Blog;
import com.hjljy.blog.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    @Update("UPDATE t_blog_info SET count = count+1 WHERE id = #{id} ")
    void setCountById(Integer id);

    @Select("SELECT DISTINCT tags FROM t_blog_info")
    List<String> getBlogTags();

    @Select("SELECT * FROM t_blog_info WHERE top=0")
    List<Blog> getTopBlog();
}