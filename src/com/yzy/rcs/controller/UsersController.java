package com.yzy.rcs.controller;

import com.yzy.rcs.service.UsersService;
import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/login.action")
    public String login(UsersVo usersVo, HttpSession session,HttpServletRequest req) {
        usersVo.setLoginip(req.getRemoteAddr());
        UsersVo loguser = usersService.login(usersVo);

        System.out.println(req.getRemoteAddr());
        if (null != loguser) {
            session.setAttribute("loguser", loguser);
            return "redirect:loadMain.action";
        }else{
            return "index.jsp";
        }

    }

    /**
     * 处理用户的分页查询请求
     * **/
    @RequestMapping("/loadAll.action")
    @ResponseBody
    public DataGridModel<UsersVo> loadUsersList(UsersVo uvo){
        return usersService.loadAll(uvo);
    }

    @RequestMapping("/loadUserManager")
    public String loadUserManager(){
        return "WEB-INF/jsp/users/userManager.jsp";
    }

    @RequestMapping("/findKey.action")
    @ResponseBody
    public DataGridModel<UsersVo> findKey(UsersVo usersVo){
        return usersService.findKey(usersVo);
    }

    @RequestMapping("/saveUsers.action")
    @ResponseBody
    public Map<String,String> saveUsers(UsersVo usersVo){
        Map<String,String> map=new HashMap<>();
        try{
            usersService.saveUsers(usersVo);
        }catch (Exception ex){
            ex.printStackTrace();
            map.put("errorMsg",ex.getMessage());
        }
        return map;
    }

    @RequestMapping("/updateUsers.action")
    @ResponseBody
    public Map<String,String> updateUsers(UsersVo usersVo){
        Map<String,String> map=new HashMap<>();
        try{
            usersService.updateUsers(usersVo);
            System.out.println(usersVo);
        }catch (Exception ex){
            ex.printStackTrace();
            map.put("errorMsg",ex.getMessage());
        }
        return map;
    }

    /*处理用户删除请求*/
    @RequestMapping("/delUsers.action")
    @ResponseBody
    public Map<String,String> delUsers(UsersVo usersVo){
        Map<String,String> map=new HashMap<>();
        try{
            usersService.delUsers(usersVo);
        }catch (Exception ex){
            ex.printStackTrace();
            map.put("errorMsg",ex.getMessage());
        }
        return map;
    }


    /**
     * 处理角色回显的请求
     * **/
    @RequestMapping("/loadUserRole")
    @ResponseBody
    public List<Integer> loadUserRole(String username){
        return usersService.loadUserRoleService(username);
    }

}
