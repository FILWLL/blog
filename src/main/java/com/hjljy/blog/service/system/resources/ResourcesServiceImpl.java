package com.hjljy.blog.service.system.resources;

import com.hjljy.blog.common.MenuTree;
import com.hjljy.blog.entity.system.Resources;
import com.hjljy.blog.mapper.system.ResourcesMapper;
import com.hjljy.blog.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 17:06
 * @Description:
 */
@Service
public class ResourcesServiceImpl extends BaseServiceImpl<Resources> implements ResourcesService {

    private final ResourcesMapper resourcesMapper;

    @Autowired
    public ResourcesServiceImpl(ResourcesMapper resourcesMapper) {
        this.resourcesMapper = resourcesMapper;
    }

    /**
     * 根据角色ID获取到对应的菜单资源树
     *
     * @param roleId
     * @return List<Tree<Resources>>
     */
    @Override
    public List<Object> getResourcesByRoleId(Integer roleId) {
        List<Object> menuList = new ArrayList<>();
        try {
            //第一步，获取到当前角色所有的菜单权限资源（不包含界面按钮）
            List<Resources> resources = resourcesMapper.getResourcesByRoleId(roleId);
            //第ER步，获取到每个顶级菜单的所有子菜单
            MenuTree menuTree = new MenuTree();
            menuList = menuTree.menuList(resources);
        } catch (Exception e) {
            e.toString();
        }
        return menuList;
    }

    @Override
    public Set<String> getPermsByUserId(Integer id) {
        Set<String> perms = resourcesMapper.getPermsByUserId(id);
        Set<String> permsSet = new HashSet<>();
        //去除空值不然会报错
        for (String perm : perms) {
            if(!StringUtils.isEmpty(perm)){
                permsSet.add(perm);
            }
        }
        return permsSet;
    }
}
