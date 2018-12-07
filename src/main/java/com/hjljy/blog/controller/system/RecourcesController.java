package com.hjljy.blog.controller.system;

import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.controller.base.BaseController;
import com.hjljy.blog.entity.system.Resources;
import com.hjljy.blog.service.system.resources.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 17:04
 * @Description:
 */
@Controller
public class RecourcesController extends BaseController{
    private final ResourcesService resourcesService;

    @Autowired
    public RecourcesController(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    @RequestMapping("system/resources/getResources")
    @ResponseBody
    public AjaxJson getResources(){
        List<Resources> resources = resourcesService.listAll();
        return new AjaxJson();
    }
}
