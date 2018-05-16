package com.yzy.rcs.service.impl;

import com.yzy.rcs.mapper.LogMapper;
import com.yzy.rcs.service.LogService;
import com.yzy.rcs.vo.LogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public void addLog(LogVo lvo) {
        // TODO Auto-generated method stub
        logMapper.addLog(lvo);
    }

}
