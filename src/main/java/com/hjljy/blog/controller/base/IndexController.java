package com.hjljy.blog.controller.base;

import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.common.Tree;
import com.hjljy.blog.entity.system.Resources;
import com.hjljy.blog.service.system.resources.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 10:38
 * @Description:
 */
@Controller
public class IndexController extends BaseController{

    private final ResourcesService resourcesService;

    @Autowired
    public IndexController(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    @GetMapping("/system/index")
    public String index(Model model){
        List<Tree<Resources>> list = resourcesService.getResourcesByRoleId(1);
        model.addAttribute("resources", list);
        return "system/index";
    }

    @RequestMapping("/getResources")
    @ResponseBody
    public AjaxJson getResources(){
        AjaxJson ajaxJson = new AjaxJson();
        List<Tree<Resources>> list = resourcesService.getResourcesByRoleId(1);
        ajaxJson.setData(list);
        return ajaxJson;
    }
}
