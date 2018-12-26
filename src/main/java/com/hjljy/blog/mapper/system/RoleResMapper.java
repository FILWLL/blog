package com.hjljy.blog.mapper.system;

import com.hjljy.blog.entity.system.RoleRes;
import com.hjljy.blog.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

@Mapper
public interface RoleResMapper extends BaseMapper<RoleRes> {


    void insertMenuList(List<RoleRes> list);
}