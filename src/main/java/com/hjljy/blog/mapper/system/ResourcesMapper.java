package com.hjljy.blog.mapper.system;

import com.hjljy.blog.entity.system.Resources;
import com.hjljy.blog.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourcesMapper extends BaseMapper<Resources> {

    List<Resources> getResourcesByRoleId(Integer roleId);
}