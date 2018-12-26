package com.hjljy.blog.service.system.role;

import com.hjljy.blog.entity.system.Role;
import com.hjljy.blog.entity.system.RoleRes;
import com.hjljy.blog.mapper.system.RoleResMapper;
import com.hjljy.blog.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 17:42
 * @Description:
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    private final RoleResMapper roleResMapper;

    @Autowired
    public RoleServiceImpl(RoleResMapper roleResMapper) {
        this.roleResMapper = roleResMapper;
    }

    @Override
    public List<RoleRes> getRoleMenuByRoleId(Integer roleId) {
        RoleRes res= new RoleRes();
        res.setRoleId(roleId);
        List<RoleRes> roleRes = roleResMapper.select(res);

        return roleRes;
    }

    @Override
    public void insertByMenuIds(Integer[] ids,Integer roleId) {
        List<RoleRes> list = new ArrayList<>();
        for (Integer id : ids) {
            RoleRes res = new RoleRes();
            res.setRoleId(roleId);
            res.setResourceId(id);
            res.setCreateTime(new Date());
            list.add(res);
        }
        roleResMapper.insertMenuList(list);
    }

    @Override
    public void deleteRoleMenuByRoleId(Integer roleId) {
        roleResMapper.deleteByPrimaryKey(roleId);
    }
}
