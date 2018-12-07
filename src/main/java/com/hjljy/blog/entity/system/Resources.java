package com.hjljy.blog.entity.system;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_resources")
public class Resources {
    /**
     * 资源ID
     */
    @Id
    private Integer id;

    /**
     * 父级资源id
     */
    private Integer pid;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源路径
     */
    @Column(name = "resource_url")
    private String resourceUrl;

    /**
     * 类型：0 表示目录  1表示菜单 2表示按钮
     */
    private Integer type;

    /**
     * 授权
     */
    private String perms;

    /**
     * 图标样式
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否禁用：1表示禁用 0 表示未禁用
     */
    private Boolean locked;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取资源ID
     *
     * @return id - 资源ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置资源ID
     *
     * @param id 资源ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父级资源id
     *
     * @return pid - 父级资源id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父级资源id
     *
     * @param pid 父级资源id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取资源路径
     *
     * @return resource_url - 资源路径
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 设置资源路径
     *
     * @param resourceUrl 资源路径
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    /**
     * 获取类型：0 表示目录  1表示菜单 2表示按钮
     *
     * @return type - 类型：0 表示目录  1表示菜单 2表示按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型：0 表示目录  1表示菜单 2表示按钮
     *
     * @param type 类型：0 表示目录  1表示菜单 2表示按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取授权
     *
     * @return perms - 授权
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 设置授权
     *
     * @param perms 授权
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * 获取图标样式
     *
     * @return icon - 图标样式
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标样式
     *
     * @param icon 图标样式
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否禁用：1表示禁用 0 表示未禁用
     *
     * @return locked - 是否禁用：1表示禁用 0 表示未禁用
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * 设置是否禁用：1表示禁用 0 表示未禁用
     *
     * @param locked 是否禁用：1表示禁用 0 表示未禁用
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}