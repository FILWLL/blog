package com.hjljy.blog.controller.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.common.Const;
import com.hjljy.blog.common.utils.MD5Util;
import com.hjljy.blog.common.utils.ShiroSessionUtil;
import com.hjljy.blog.controller.base.BaseController;
import com.hjljy.blog.entity.system.Account;
import com.hjljy.blog.entity.system.AccountVO;
import com.hjljy.blog.service.system.account.AccountService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.NewThreadAction;

import java.util.Date;
import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2018/12/6 0006 17:04
 * @Description:
 */
@Controller
@RequestMapping("/system/account")
public class AccountController extends BaseController{
    public static String Path = "system/account/";


    private AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @RequiresPermissions("sys:account:index")
    @RequestMapping("/index")
    public String index(){
        return Path+"index";
    }

    @RequiresPermissions("sys:account:index")
    @RequestMapping("/getAccountByPage")
    @ResponseBody
    public AjaxJson getAccountByPage(int page, int limit){
        AjaxJson aj = new AjaxJson();
        Page<Account> page1 = getPage(page,limit );
        PageInfo<AccountVO> accountVO = service.getAccountVOByPage(page1);
        aj.setPageSuccessData(accountVO.getList(),accountVO.getTotal());
        return aj;
    }

    @RequestMapping("/addOrEdit")
    @ResponseBody
    public AjaxJson addOrEdit(Account account){
        AjaxJson aj = new AjaxJson();
        /* layui开关选择只会传一个true 所以要进行判断*/
        if(account.getStatus()==null){
            account.setStatus(false);
        }
        if(account.getId()!=null){
            account.setUpdater(ShiroSessionUtil.getAccountName());
            account.setModifiedTime(new Date());
            service.updateSelectiveById(account);
            aj.setSuccessMsg(Const.OP_SUCCEED);
            return aj;
        }
        account.setCreateTime(new Date());
        String pwd = MD5Util.encrypt(account.getUsername(), account.getPassword());
        account.setPassword(pwd);
        account.setCreator(ShiroSessionUtil.getAccountName());
        service.insert(account);
        aj.setSuccessMsg(Const.OP_SUCCEED);
        return aj;
    }

    @RequestMapping("/delBatch")
    @ResponseBody
    public AjaxJson delBatch(String ids){
        AjaxJson aj = new AjaxJson();
        service.deleteByIds(ids);
        aj.setSuccessMsg(Const.OP_SUCCEED);
        return aj;
    }
}
