package com.yzy.rcs.service;

import com.yzy.rcs.vo.ChecksVo;
import com.yzy.rcs.vo.DataGridModel;

import java.util.Map;

public interface ChecksService {
    /**
     * 加载检查单相关数据
     * **/
    public Map<String, Object> loadCheckData(String rentid, String username);

    /***
     * 保存检查单信息
     * */
    public void saveChecks(ChecksVo cvo);

    DataGridModel<ChecksVo> findAllChecks(ChecksVo cvo);

    void updateChecks(ChecksVo cvo);
}
