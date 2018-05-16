package com.yzy.rcs.controller;

import com.yzy.rcs.domain.RoleMenus;
import com.yzy.rcs.service.RoleMenusService;
import com.yzy.rcs.service.RolesService;
import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.RolesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RolesController {
    @Autowired
    private RolesService rolesService;
    @Autowired
    private RoleMenusService roleMenusService;

    @RequestMapping("/loadRoleManager.action")
    public String loadRoleManager(){
        return "WEB-INF/jsp/roles/rolesManager.jsp";
    }

    @RequestMapping("/findRolesKey")
    @ResponseBody
    public DataGridModel<RolesVo> findRolesKey(RolesVo rolesVo){
        return rolesService.findRolesKey(rolesVo);
    }

    @RequestMapping("/saveRoles.action")
    @ResponseBody
    public Map<String,String> saveRoles(RolesVo rolesVo){
        Map<String,String> map=new HashMap<>();
        try{
            rolesService.saveRoles(rolesVo);
        }catch(Exception ex){
            ex.printStackTrace();
            map.put("erroeMsg",ex.getMessage());
        }
        return map;
    }

    @RequestMapping("/updateRoles.action")
    @ResponseBody
    public Map<String,String> updateRoles(RolesVo rolesVo){
        Map<String,String> map=new HashMap<>();
        try{
            rolesService.updateRoles(rolesVo);
        }catch(Exception ex){
            ex.printStackTrace();
            map.put("erroeMsg",ex.getMessage());
        }
        return map;
    }

    @RequestMapping("/delRoles.action")
    @ResponseBody
    public Map<String,String> delRoles(RolesVo rolesVo){
        Map<String,String> map=new HashMap<>();
        try{
            rolesService.delRoles(rolesVo);
        }catch(Exception ex){
            ex.printStackTrace();
            map.put("erroeMsg",ex.getMessage());
        }
        return map;
    }

    /**
     * 处理角色分页显示的请求
     * **/
    @RequestMapping("/loadAllRolesList.action")
    @ResponseBody
    public List<RolesVo> loadAllRolesList(){
        return rolesService.loadAllRolesListService();
    }

    /***
     * 处理加载某个角色资源的请求的方法
     * **/
    @RequestMapping("/loadRoleMenus")
    @ResponseBody
    public List<RoleMenus> loadRoleMenus(Integer roleid){

        return roleMenusService.loadRoleMenusService(roleid);
    }

    /**
     * 处理角色授权的请求
     * **/
    @RequestMapping("/grantMenusToRoles")
    @ResponseBody
    public Map<String,String> grantMenusToRoles(String rmids){
        Map<String,String> map = new HashMap<String,String>();
        try{
            roleMenusService.saveRoleMeunsService(rmids);
        }catch(Exception ex){
            map.put("errorMsg", ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }

}
