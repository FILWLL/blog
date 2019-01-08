package com.hjljy.blog.entity.blog;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_blog_info")
public class Blog {
    @Id
    private Integer id;

    /**
     * 文章类型
     */
    private String type;

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
    @OrderBy(value = "DESC")
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
     * 博客路径
     */
    private String url;

    /**
     * 封面
     */
    private String face;

    /**
     * 摘要
     */
    private String abs;

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
     * @return type - 文章类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置文章类型
     *
     * @param type 文章类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
     * 获取博客路径
     *
     * @return url - 博客路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置博客路径
     *
     * @param url 博客路径
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取封面
     *
     * @return face - 封面
     */
    public String getFace() {
        return face;
    }

    /**
     * 设置封面
     *
     * @param face 封面
     */
    public void setFace(String face) {
        this.face = face == null ? null : face.trim();
    }

    /**
     * 获取摘要
     *
     * @return abstract - 摘要
     */
    public String getAbs() {
        return abs;
    }

    /**
     * 设置摘要
     *
     * @param abs 摘要
     */
    public void setAbs(String abs) {
        this.abs = abs == null ? null : abs.trim();
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