package com.hjljy.blog.controller.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.common.Const;
import com.hjljy.blog.controller.base.BaseController;
import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.entity.system.Role;
import com.hjljy.blog.entity.system.RoleRes;
import com.hjljy.blog.service.system.role.RoleService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 17:43
 * @Description:
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {

    public static String Path = "system/role/";

    @Autowired
    private RoleService service;

    @RequestMapping("/index")
    public String index(){
        return Path+"index";
    }

    @RequestMapping("/getRoleByPage")
    @ResponseBody
    public AjaxJson getRoleByPage(int page,int limit){
        AjaxJson ajaxJson = new AjaxJson();
        Page<Role> page1 = getPage(page,limit );
        PageInfo<Role> pageInfo = service.listForDataGrid(page1);
        ajaxJson.setPageSuccessData(pageInfo.getList(), pageInfo.getTotal());
        return ajaxJson;
    }

    @RequestMapping("/getRoles")
    @ResponseBody
    public AjaxJson getRole(){
        AjaxJson ajaxJson = new AjaxJson();
        List<Role> roles = service.listAll();
        ajaxJson.setSuccessData(roles);
        return ajaxJson;
    }

    @RequestMapping("/getRoleMenuByRoleId")
    @ResponseBody
    public AjaxJson getRoleMenuByRoleId(Integer roleId){
        AjaxJson ajaxJson = new AjaxJson();
        List<RoleRes> resList = service.getRoleMenuByRoleId(roleId);
        ajaxJson.setSuccessData(resList);
        return ajaxJson;
    }

    @RequestMapping("/addRoleMenu")
    @ResponseBody
    @Transactional
    public AjaxJson addRoleMenu(Integer[] ids,Integer roleId){
        AjaxJson ajaxJson = new AjaxJson();
        service.deleteRoleMenuByRoleId(roleId);
        service.insertByMenuIds(ids,roleId);
        ajaxJson.setSuccessMsg(Const.OP_SUCCEED);
        return ajaxJson;
    }

}
