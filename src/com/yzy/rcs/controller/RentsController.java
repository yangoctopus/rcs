package com.yzy.rcs.controller;

import com.yzy.rcs.domain.Users;
import com.yzy.rcs.service.RentsService;
import com.yzy.rcs.utils.DateUtils;
import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.RentsVo;
import com.yzy.rcs.vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RentsController {
    @Autowired
    private RentsService rentsService;

    @RequestMapping("/loadRentCar.action")
    public String loadRentCar(){
        return "WEB-INF/jsp/rents/rentCar.jsp";
    }

    @RequestMapping("/loadRentManager.action")
    public String loadRentManager(){
        return "WEB-INF/jsp/rents/rentsManager.jsp";
    }

    @RequestMapping("/findAllRents")
    @ResponseBody
    public DataGridModel<RentsVo> findAllRents(RentsVo rentsVo){
        System.out.println(rentsVo.getBegindate());
        return rentsService.findAllRents(rentsVo);
    }

    /**
     * 处理加载出租单，对话框中数据的请求
     * **/
    @RequestMapping("/loadRentData")
    @ResponseBody
    public RentsVo loadRentData(HttpSession session, String custid,String carid){

        RentsVo rvo = new RentsVo();

        UsersVo uvo = (UsersVo) session.getAttribute("loguser");
        rvo.setUsername(uvo.getUsername());
        rvo.setRentid(DateUtils.randomId()); //出租单
        rvo.setCustid(custid);
        rvo.setCarid(carid);

        return rvo;
    }


    @RequestMapping("/saveRents")
    @ResponseBody
    public Map<String,String> saveRents(RentsVo rentsVo){
        Map<String,String> map=new HashMap<>();
        try{
            rentsService.saveRents(rentsVo);
        }catch(Exception ex){
            map.put("errorMsg",ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/updateRents")
    @ResponseBody
    public Map<String,String> updateRents(RentsVo rentsVo,HttpSession session){
        Map<String,String> map=new HashMap<>();
        Users loguser= (Users) session.getAttribute("loguser");
        rentsVo.setUsername(loguser.getUsername());
        try{
            rentsService.updateRents(rentsVo);
        }catch(Exception ex){
            map.put("error",ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }

    @RequestMapping("/delRents")
    @ResponseBody
    public Map<String,String> delRents(RentsVo rentsVo){
        Map<String,String> map=new HashMap<>();
        try{
            rentsService.delRents(rentsVo);
        }catch(Exception ex){
            map.put("error",ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }

    /**
     * 处理验证出租单是否存在的请求
     * **/
    @RequestMapping("/checkRents")
    @ResponseBody
    public String checkRents(String rentid){
        RentsVo rvo = rentsService.loadRentsByRentid(rentid);

        if(rvo!=null){
            return "success";
        }else{
            return "error";
        }
    }
}
