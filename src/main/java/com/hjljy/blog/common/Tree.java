package com.hjljy.blog.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.hjljy.blog.entity.system.Resources;

/**
 * tree TODO <br>
 *
 * @author kangxu2 2017-1-7
 *
 */
public class Tree<T> {
    /**
     * 节点ID
     */
    private Integer id;
    /**
     * 显示节点文本
     */
    private String name;
    /**
     * 节点状态，open closed
     */
    private Map<String, Object> state;
    /**
     * 节点是否被选中 true false
     */
    private boolean checked = false;
    /**
     * 节点属性
     */
    private Map<String, Object> attributes;

    /**
     * 节点的子节点
     */
    private List<Tree<T>> children = new ArrayList<Tree<T>>();

    /**
     * 父ID
     */
    private Integer parentId;
    /**
     * 是否有父节点
     */
    private boolean hasParent = false;
    /**
     * 是否有子节点
     */
    private boolean hasChildren = false;

    public Tree(Integer id, String name, String icon, Integer sort, String resourceUrl) {
        this.id=id;
        this.name=name;
        Map<String, Object> attributes = new HashMap<>(16);
        attributes.put("icon", icon);
        attributes.put("sort", sort);
        attributes.put("resourceUrl", resourceUrl);
        setAttributes(attributes);
    }

    public Tree(List<Tree<T>> tree, Integer id, String icon, String name, String resourceUrl) {
        this.children=tree;
        this.id=id;
        this.name=name;
        Map<String, Object> attributes = new HashMap<>(16);
        attributes.put("icon", icon);
        attributes.put("resourceUrl", resourceUrl);
        setAttributes(attributes);
        setChildren(true);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }

    public boolean isHasParent() {
        return hasParent;
    }

    public void setHasParent(boolean isParent) {
        this.hasParent = isParent;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setChildren(boolean isChildren) {
        this.hasChildren = isChildren;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Tree(Integer id, String name, Map<String, Object> state, boolean checked, Map<String, Object> attributes,
                List<Tree<T>> children, boolean isParent, boolean isChildren, Integer parentID) {
        super();
        this.id = id;
        this.name = name;
        this.state = state;
        this.checked = checked;
        this.attributes = attributes;
        this.children = children;
        this.hasParent = isParent;
        this.hasChildren = isChildren;
        this.parentId = parentID;
    }

    public Tree() {
        super();
    }

    @Override
    public String toString() {

        return JSON.toJSONString(this);
    }

}