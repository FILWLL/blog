package com.hjljy.blog.controller.system;

import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.common.Const;
import com.hjljy.blog.common.annotation.BlogLog;
import com.hjljy.blog.common.utils.ShiroSessionUtil;
import com.hjljy.blog.controller.base.BaseController;
import com.hjljy.blog.entity.system.Resources;
import com.hjljy.blog.service.system.resources.ResourcesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 17:04
 * @Description:
 */
@Controller
@RequestMapping("/system/resources")
public class RecourcesController extends BaseController{

    public static String Path = "system/resources/";

    private final ResourcesService resourcesService;

    @Autowired
    public RecourcesController(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }


    @RequestMapping("/index")
    public String index(){
        return Path+"index";
    }

    @RequestMapping("/getAllResources")
    @ResponseBody
    public AjaxJson getResources(){
        AjaxJson aj= new AjaxJson();
        List<Resources> resources = resourcesService.listAll();
        aj.setData(resources);
        return aj;
    }

    @RequestMapping("/getResourcesTree")
    @ResponseBody
    public AjaxJson getResourcesTree(){
        AjaxJson ajaxJson = new AjaxJson();
        List<Object> list = resourcesService.getResourcesByRoleId(ShiroSessionUtil.getAccount().getRoleId());
        ajaxJson.setData(list);
        return ajaxJson;
    }

    //@RequiresPermissions("sys:res:add")
    @BlogLog(description = "添加或者修改菜单信息")
    @RequestMapping("/addOrEdit")
    @ResponseBody
    public AjaxJson addOrEdit(Resources res){
        AjaxJson ajaxJson = new AjaxJson();
        if(res.getLocked()==null){
            res.setLocked(false);
        }
        res.setCreateTime(new Date());
        resourcesService.insertSelective(res);
        ajaxJson.setSuccessMsg(Const.OP_SUCCEED);
        return ajaxJson;
    }
}
