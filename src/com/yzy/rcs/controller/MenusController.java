package com.yzy.rcs.controller;

import com.yzy.rcs.service.MenusService;
import com.yzy.rcs.vo.MenusVo;
import com.yzy.rcs.vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenusController {
    @Autowired
    private MenusService menusService;

    @RequestMapping("/loadMenus.action")
    @ResponseBody
    public List<MenusVo> loadMneus(){

        return menusService.loadMenus();
    }

    /***
     * 打开授权的窗口页面
     * **/
    @RequestMapping("/loadPrivilegeUI.action")
    public String loadPrivilegeUI(Integer roleid,Model model){
        model.addAttribute("roleid", roleid);
        return "WEB-INF/jsp/privilege/privilege.jsp";
    }

    /***
     * 处理加载所有资源的请求
     * **/
    @RequestMapping("/loadMenusResources")
    @ResponseBody
    public List<MenusVo> loadMenusResources(HttpSession session){
        UsersVo uvo = (UsersVo) session.getAttribute("loguser");
        return menusService.loadMenusResources(uvo.getUsername());
    }
}
