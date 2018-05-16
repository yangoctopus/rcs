package com.yzy.rcs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest req,
                                HttpServletResponse resp, Object obj, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest req,
                           HttpServletResponse resp, Object obj, ModelAndView mav)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse resp, Object obj) throws Exception {
        // TODO Auto-generated method stub
        HttpSession session=req.getSession();

        //获得当前登录用户
        Object uvo=session.getAttribute("loguser");

        if(uvo!=null){
            return true; //放行
        }
        resp.sendRedirect("index.jsp");
        return false;
    }

}
