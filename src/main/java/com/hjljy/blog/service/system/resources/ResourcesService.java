package com.hjljy.blog.service.system.resources;

import com.hjljy.blog.entity.system.Resources;
import com.hjljy.blog.service.base.BaseService;

import java.util.List;
import java.util.Set;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 17:06
 * @Description:
 */
public interface ResourcesService extends BaseService<Resources> {
    /**
     * 根据角色信息查询资源信息
     * @param roleId
     * @return
     */
    List<Object> getResourcesByRoleId(Integer roleId);

    /**
     * 根据用户ID获取到权限信息
     * @param id
     * @return
     */
    Set<String> getPermsByUserId(Integer id);
}
