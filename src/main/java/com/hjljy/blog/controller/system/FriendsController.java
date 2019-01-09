package com.hjljy.blog.controller.system;

import com.hjljy.blog.common.AjaxJson;
import com.hjljy.blog.common.Const;
import com.hjljy.blog.controller.base.BaseController;
import com.hjljy.blog.entity.system.Friends;
import com.hjljy.blog.service.system.friends.FriendsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: HJLJY
 * @Date: 2019/1/9 0009 16:57
 * @Description:
 */
@Controller
@RequestMapping("/friends/")
public class FriendsController extends BaseController<Friends> {
    public static String Path = "system/friend/";
    private final FriendsService friendsService;

    public FriendsController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    @RequestMapping("/index")
    public String index(){
        return Path+"index";
    }
    @RequestMapping("/addOrEdit")
    @ResponseBody
    public AjaxJson addOrEdit(Friends friends){
        AjaxJson ajaxJson = new AjaxJson();
        friendsService.insertSelective(friends);
        ajaxJson.setSuccessMsg(Const.OP_SUCCEED);
        return ajaxJson;
    }
    @RequestMapping("/del")
    @ResponseBody
    public AjaxJson del(String ids){
        AjaxJson ajaxJson = new AjaxJson();
        friendsService.deleteByIds(ids);
        ajaxJson.setSuccessMsg(Const.OP_SUCCEED);
        return ajaxJson;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public AjaxJson getAll(){
        AjaxJson ajaxJson = new AjaxJson();
        List<Friends> friends = friendsService.listAll();
        ajaxJson.setSuccessData(friends);
        return ajaxJson;
    }
}
