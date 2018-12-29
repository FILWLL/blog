package com.hjljy.blog.controller.blog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.common.Const;
import com.hjljy.blog.common.PageData;
import com.hjljy.blog.common.utils.ShiroSessionUtil;
import com.hjljy.blog.common.utils.TemplatesUtil;
import com.hjljy.blog.controller.base.BaseController;
import com.hjljy.blog.entity.blog.Blog;
import com.hjljy.blog.service.blog.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Templates;
import java.util.Date;
import java.util.UUID;

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
        Page<Blog> page = new Page<>();
        page.setPageSize(pageData.getPage());
        page.setPageNum(pageData.getLimit());
        page.setOrderBy("create_time");
        PageInfo<Blog> blogPageInfo = blogService.listForDataGrid(page, blog);
        System.out.println(123);
        aj.setPageSuccessData(blogPageInfo.getList(), blogPageInfo.getTotal());
        return aj;
    }



    @PostMapping("/add")
    @ResponseBody
    public AjaxJson addBlog(Blog blog){
        AjaxJson aj = new AjaxJson();
        if (blog.getAuthor()==null){
            blog.setAuthor(ShiroSessionUtil.getAccountName());
        }
        blog.setCreateTime(new Date());
        String url = TemplatesUtil.createHtml(blog.getCreateTime().getTime() + blog.getTitle(), blog.getContent());
        blog.setUrl(url);
        blogService.insertSelective(blog);
        aj.setSuccessMsg(Const.OP_SUCCEED);
        return aj;
    }
}
