package com.yzy.rcs.service;

import com.yzy.rcs.vo.LogVo;

public interface LogService {
    /**
     * 保存登录日志信息
     * **/
    public void addLog(LogVo lvo);

}
