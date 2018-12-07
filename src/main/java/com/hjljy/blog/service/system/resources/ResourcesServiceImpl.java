package com.hjljy.blog.service.system.resources;

import com.hjljy.blog.common.Tree;
import com.hjljy.blog.entity.system.Resources;
import com.hjljy.blog.mapper.system.ResourcesMapper;
import com.hjljy.blog.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<Tree<Resources>> getResourcesByRoleId(Integer roleId) {
        List<Tree<Resources>> list = new ArrayList<>();
        try {
            List<Resources> resources = resourcesMapper.getResourcesByRoleId(roleId);
            resources.stream().filter(res -> res.getPid() == 0).forEach(res1 -> {
                List<Tree<Resources>> tree = createTree(resources, res1.getId());
                if(!CollectionUtils.isEmpty(tree)){
                    list.add(new Tree<Resources>(tree,res1.getId(),res1.getIcon(),res1.getName(),res1.getResourceUrl()));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

//        //遍历获取到的菜单资源，封装到树形结构当中
//        for (Resources resource : resources) {
//            Tree<Resources> tree = new Tree<>();
//            tree.setId(resource.getId());
//            tree.setParentId(resource.getPid());
//            tree.setText(resource.getName());
//            Map<String, Object> attributes = new HashMap<>(16);
//            attributes.put("url", resource.getResourceUrl());
//            attributes.put("icon", resource.getIcon());
//            tree.setAttributes(attributes);
//            list.add(tree);
//        }
//        return list;
    }

    private List<Tree<Resources>> createTree(List<Resources> resources, Integer pid) {
        return resources.stream().filter(res -> res.getId() != 0 && res.getPid() == pid)
                .map(res -> new Tree<Resources>(res.getId(),res.getName(),res.getIcon(),res.getSort(),res.getResourceUrl())).collect(Collectors.toList());
    }
}
