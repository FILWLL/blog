package com.hjljy.blog.controller.base;

import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.common.utils.ShiroSessionUtil;
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



    @GetMapping("/system/index")
    public String index(Model model){
        return "system/index";
    }


}
