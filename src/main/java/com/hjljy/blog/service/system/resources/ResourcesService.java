package com.hjljy.blog.service.system.resources;

import com.hjljy.blog.common.Tree;
import com.hjljy.blog.entity.system.Resources;
import com.hjljy.blog.service.base.BaseService;

import java.util.List;

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
    List<Tree<Resources>> getResourcesByRoleId(Integer roleId);
}
