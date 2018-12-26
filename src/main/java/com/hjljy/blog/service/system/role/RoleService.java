package com.hjljy.blog.service.system.role;

import com.hjljy.blog.entity.system.Role;
import com.hjljy.blog.entity.system.RoleRes;
import com.hjljy.blog.service.base.BaseService;

import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 17:42
 * @Description:
 */
public interface RoleService  extends BaseService<Role>{
    List<RoleRes> getRoleMenuByRoleId(Integer roleId);

    void insertByMenuIds(Integer[] ids,Integer roleId);

    void deleteRoleMenuByRoleId(Integer roleId);
}
