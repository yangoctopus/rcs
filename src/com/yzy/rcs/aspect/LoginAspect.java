package com.yzy.rcs.aspect;

import com.yzy.rcs.service.LogService;
import com.yzy.rcs.service.impl.UsersServiceImpl;
import com.yzy.rcs.utils.DateUtils;
import com.yzy.rcs.vo.LogVo;
import com.yzy.rcs.vo.UsersVo;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAspect {
    @Autowired
    private LogService logService;

	public LoginAspect(){
		System.out.println("===============LoginAspect");
	}

    @AfterReturning(pointcut="execution(* com.yzy.rcs.service.impl.UsersServiceImpl.login(..))",returning="rv")
    public Object loginLog(Object rv){
        System.out.println(rv);
        UsersVo uvo=(UsersVo) rv;

        //创建LogVo对象
        LogVo lvo = new LogVo();
        lvo.setLoginip(uvo.getLoginip());
        lvo.setLogintime(DateUtils.getFormatDate());
        lvo.setLoginname(uvo.getUsername());

        logService.addLog(lvo);

        return rv;
    }


}
