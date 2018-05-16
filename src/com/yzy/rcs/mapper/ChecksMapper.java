package com.yzy.rcs.mapper;

import com.yzy.rcs.domain.Checks;
import com.yzy.rcs.vo.ChecksVo;

import java.util.List;


public interface ChecksMapper {
    /**
     * 保存检查单信息
     * **/
    public void saveChecks(Checks checks);

    List<Checks> findAllChecks();

    void updateChecks(ChecksVo cvo);
}
