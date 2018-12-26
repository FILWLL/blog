package com.hjljy.blog.common;
import com.hjljy.blog.entity.system.Resources;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/19 0019 17:24
 * @Description: 树形菜单资源
 */
public class MenuTree {

    public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();
    public List<Object> list = new ArrayList<Object>();
    public List<Resources> menuCommon;

    public List<Object> menuList(List<Resources> menu){
        this.menuCommon = menu;
        for (Resources res : menu) {
            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();
            if(res.getPid()==0){
                mapArr.put("id", res.getId());
                mapArr.put("url", res.getResourceUrl());
                mapArr.put("name", res.getName());
                mapArr.put("icon", res.getIcon());
                mapArr.put("pid", res.getPid());
                mapArr.put("children", menuChild(res.getId()));
                list.add(mapArr);
            }
        }
        return list;
    }


    public List<?> menuChild(int id){
        List<Object> lists = new ArrayList<Object>();
        for(Resources res:menuCommon){
            Map<String,Object> childArray = new LinkedHashMap<String, Object>();
            if(res.getPid() == id){
                childArray.put("id", res.getId());
                childArray.put("name", res.getName());
                childArray.put("icon", res.getIcon());
                childArray.put("url", res.getResourceUrl());
                childArray.put("pid", res.getPid());
                childArray.put("children", menuChild(res.getId()));
                lists.add(childArray);
            }
        }
        return lists;
    }
}
