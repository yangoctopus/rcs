package com.yzy.rcs.controller;

import com.yzy.rcs.service.ChecksService;
import com.yzy.rcs.vo.ChecksVo;
import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ChecksController {
    @Autowired
    private ChecksService checksService;

    @RequestMapping("/loadRebackCar.action")
    public String loadRebackCar(){
        return "WEB-INF/jsp/checks/rebackCar.jsp";
    }

    @RequestMapping("/loadCheck.action")
    public String loadCheck(){
        return "WEB-INF/jsp/checks/checksManager.jsp";
    }
    /**
     * 处理加载检查单相关数据的请求
     * **/
    @RequestMapping("/loadCheckData")
    @ResponseBody
    public Map<String,Object> loadCheckData(String rentid, HttpSession session){
        UsersVo uvo = (UsersVo) session.getAttribute("loguser");
        return checksService.loadCheckData(rentid,uvo.getUsername());
    }

    /***
     * 保存出租单信息
     * **/
    @RequestMapping("/saveChecks")
    @ResponseBody
    public Map<String,String> saveChecks(ChecksVo cvo){
        Map<String,String> map = new HashMap<String,String>();
        try{
            checksService.saveChecks(cvo);
        }catch(Exception ex){
            map.put("errorMsg", ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/findAllChecks")
    @ResponseBody
    public DataGridModel<ChecksVo> findAllChecks(ChecksVo checksVo){

        return checksService.findAllChecks(checksVo);

    }

    /***
     * 保存出租单信息
     * **/
    @RequestMapping("/updateChecks")
    @ResponseBody
    public Map<String,String> updateChecks(ChecksVo cvo){
        Map<String,String> map = new HashMap<String,String>();
        try{
            checksService.updateChecks(cvo);
        }catch(Exception ex){
            map.put("errorMsg", ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }



}
