package com.hjljy.blog.controller.blog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.common.Const;
import com.hjljy.blog.common.PageData;
import com.hjljy.blog.common.annotation.BlogLog;
import com.hjljy.blog.common.utils.ShiroSessionUtil;
import com.hjljy.blog.common.utils.TemplatesUtil;
import com.hjljy.blog.controller.base.BaseController;
import com.hjljy.blog.entity.blog.Blog;
import com.hjljy.blog.service.blog.BlogService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.xml.transform.Templates;
import java.util.*;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/27 0027 18:15
 * @Description:
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController<Blog> {


    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    private final BlogService blogService;


    @RequestMapping("/index")
    public String index(){
        return "blog/index";
    }


    @GetMapping("/getBlogByPage")
    @ResponseBody
    public AjaxJson getBlogByPage(PageData pageData,Blog blog){
        AjaxJson aj = new AjaxJson();
        pageData.setOrderBy("create_time desc");
        Example example = new Example(Blog.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(blog.getTitle())){
            criteria.andLike("title", "%"+blog.getTitle()+"%");
        }
        if (!StringUtils.isEmpty(blog.getTags()) ){
            criteria.andLike("tags", "%"+blog.getTags()+"%");
        }
        if (!StringUtils.isEmpty(blog.getType())) {
            criteria.andEqualTo("type", blog.getType());
        }
        PageInfo<Blog> blogPageInfo = blogService.listForDataGrid(pageData, example);
        aj.setPageSuccessData(blogPageInfo.getList(), blogPageInfo.getTotal());
        return aj;
    }


    @RequiresPermissions("sys:blog:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxJson addBlog(Blog blog){
        AjaxJson aj = new AjaxJson();
        blog.setCreateTime(new Date());
        String url = TemplatesUtil.createHtml(blog.getTitle()+blog.getCreateTime().getTime(), blog.getContent(),blog.getTitle());
        blog.setUrl(url);
        if (blog.getId()!=null){
            blogService.updateSelectiveById(blog);
            aj.setSuccessMsg(Const.OP_SUCCEED);
            return aj;
        }
        if (blog.getAuthor()==null){
            blog.setAuthor(ShiroSessionUtil.getAccountName());
        }
        if(StringUtils.isEmpty(blog.getAbs())){
            blog.setAbs("人生的高度， 不是你看清了多少事， 而是你看轻了多少事。 心灵的宽度， 不是你认识了多少人， 而是你包容了多少人。 做人如山， 望万物，而容万物。 做人似水， 能进退，而知进退...");
        }
        blogService.insertSelective(blog);
        aj.setSuccessMsg(Const.OP_SUCCEED);
        return aj;
    }

    @RequiresPermissions("sys:blog:del")
    @PostMapping("/del")
    @ResponseBody
    public AjaxJson delBatchBlog(String ids){
        AjaxJson aj = new AjaxJson();
        blogService.deleteByIds(ids);
        aj.setSuccessMsg(Const.OP_SUCCEED);
        return aj;
    }

    @GetMapping("/getBlogTags")
    @ResponseBody
    public AjaxJson getBlogTags(){
        AjaxJson aj = new AjaxJson();
        List<String> blogTags = blogService.getBlogTags();
        for (String blogTag : blogTags) {
            String[] split = blogTag.split(",");
            for (String s : split) {
                set.add(s);
            }
        }
        aj.setSuccessData(set);
        return aj;
    }

    @GetMapping("/getBlogTop")
    @ResponseBody
    public AjaxJson getBlogTop(){
        AjaxJson aj = new AjaxJson();
        List<Blog> topBlog = blogService.getTopBlog();
        aj.setSuccessData(topBlog);
        return aj;
    }
}
