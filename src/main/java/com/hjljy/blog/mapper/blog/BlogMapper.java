package com.hjljy.blog.mapper.blog;

import com.hjljy.blog.entity.blog.Blog;
import com.hjljy.blog.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
    @Update("UPDATE t_blog_info SET count = count+1 WHERE id = #{id} ")
    void setCountById(Integer id);
}