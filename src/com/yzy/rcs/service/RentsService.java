package com.yzy.rcs.service;

import com.yzy.rcs.domain.Rents;
import com.yzy.rcs.vo.DataGridModel;
import com.yzy.rcs.vo.RentsVo;



public interface RentsService {
    public DataGridModel<RentsVo> findAllRents(RentsVo rentsVo);
    public void saveRents(RentsVo rentsVo);
    public void updateRents(RentsVo rentsVo);
    public void delRents(RentsVo rentsVo);

    RentsVo loadRentsByRentid(String rentid);
}
