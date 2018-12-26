package com.hjljy.blog.entity.system;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_blog_info")
public class Blog {
    private Integer id;

    /**
     * 文章类型
     */
    @Column(name = "typeId")
    private Integer typeid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 标签
     */
    private String tags;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 作者
     */
    private String author;

    /**
     * 状态
     */
    private String status;

    /**
     * 次数
     */
    private Integer count;

    /**
     * 内容
     */
    private String content;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取文章类型
     *
     * @return typeId - 文章类型
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 设置文章类型
     *
     * @param typeid 文章类型
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取标签
     *
     * @return tags - 标签
     */
    public String getTags() {
        return tags;
    }

    /**
     * 设置标签
     *
     * @param tags 标签
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
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
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取次数
     *
     * @return count - 次数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置次数
     *
     * @param count 次数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}