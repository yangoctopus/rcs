package com.yzy.rcs.mapper;

import com.yzy.rcs.domain.Rents;
import com.yzy.rcs.vo.RentsVo;

import java.util.List;

public interface RentsMapper {
    public List<Rents> findAllRents(Rents rents);
    public void saveRents(Rents rents);
    public void updateRents(Rents rents);
    public void delRents(Rents rents);

    Rents loadRentsRentid(String rentid);

    void updateRentsStatus(Rents rents);
}
