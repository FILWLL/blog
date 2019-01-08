package com.hjljy.blog.controller.base;

import com.hjljy.blog.entity.blog.Blog;
import com.hjljy.blog.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 10:38
 * @Description:
 */
@Controller
public class IndexController extends BaseController{

    @Autowired
    private  BlogService blogService;

    @GetMapping("/system/index")
    public String index(Model model){
        return "system/index";
    }

    @PostMapping("/setCount")
    @ResponseBody
    public void setCount(Integer id){
        blogService.setCountById(id);
    }
}
