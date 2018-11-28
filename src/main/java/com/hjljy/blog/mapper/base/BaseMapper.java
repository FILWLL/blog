package com.hjljy.blog.mapper.base;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/13 0013 09:48
 * @Description:    通用MAPPER类 包含基础的CRUD
 */
public interface BaseMapper<T>  extends Mapper<T>, MySqlMapper<T>, ConditionMapper,IdsMapper {
}
