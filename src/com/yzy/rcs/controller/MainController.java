package com.yzy.rcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/loadMain.action")
    public String loadMain(){
        return "WEB-INF/jsp/main/main.jsp";
    }

    @RequestMapping("/loadDesk.action")
    public String loadDesk(){
        return "WEB-INF/jsp/main/desk.jsp";
    }

    @RequestMapping("/loadLeft.action")
    public String loadLeft(){
        return "WEB-INF/jsp/main/left.jsp";
    }

    @RequestMapping("/loadTop.action")
    public String loadTop(){
        return "WEB-INF/jsp/main/top.jsp";
    }

    @RequestMapping("/loadCenter.action")
    public String loadCenter(){
        return "WEB-INF/jsp/main/center.jsp";
    }

}
